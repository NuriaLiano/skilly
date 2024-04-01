# [Solución] Sistema de Gestión de Pedidos para Servicio de Entrega a Domicilio

## Estructura del proyecto

~~~md
delivery_service/
├── api/
│   ├── config/
│   │   └── database.php
│   ├── models/
│   │   └── Order.php
│   └── index.php
├── frontend/
│   ├── css/
│   │   └── styles.css
│   ├── js/
│   │   └── script.js
│   ├── includes/
│   │   └── funciones.php
│   ├── views/
│   │   ├── add_order.php
│   │   ├── edit_order.php
│   │   └── list_orders.php
│   └── index.php
└── .htaccess
~~~

## Database.php

~~~php
class Database {
    private $host = "127.0.0.1";
    private $db_name = "delivery_service";
    private $username = "root";
    private $password = "";
    public $conn;

    public function getConnection() {
        $this->conn = null;
        try {
            $this->conn = new PDO("mysql:host=" . $this->host . ";dbname=" . $this->db_name, $this->username, $this->password);
            $this->conn->exec("set names utf8");
        } catch(PDOException $exception) {
            echo "Connection error: " . $exception->getMessage();
        }
        return $this->conn;
    }
}
~~~

## api/models/Order.php

~~~php
<?php
class Order {
    // Conexión a la base de datos y nombre de la tabla
    private $conn;
    private $table_name = "orders";

    // Propiedades del objeto Order
    public $id;
    public $customer_name;
    public $address;
    public $order_details;
    public $status;
    public $created_at;

    // Constructor con $db como conexión a la base de datos
    public function __construct($db) {
        $this->conn = $db;
    }

    // Leer todos los pedidos
    public function read() {
        $query = "SELECT * FROM " . $this->table_name . " ORDER BY created_at DESC";
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt;
    }

    // Leer un solo pedido
    public function readOne() {
        $query = "SELECT * FROM " . $this->table_name . " WHERE id = ? LIMIT 0,1";
        $stmt = $this->conn->prepare($query);
        $stmt->bindParam(1, $this->id);
        $stmt->execute();
        $row = $stmt->fetch(PDO::FETCH_ASSOC);

        if ($row) {
            $this->customer_name = $row['customer_name'];
            $this->address = $row['address'];
            $this->order_details = $row['order_details'];
            $this->status = $row['status'];
            $this->created_at = $row['created_at'];
            return true;
        }
        return false;
    }

    // Crear un nuevo pedido
    public function create() {
        $query = "INSERT INTO " . $this->table_name . " SET customer_name=:customer_name, address=:address, order_details=:order_details, status=:status";
        $stmt = $this->conn->prepare($query);

        // Limpiar datos
        $this->customer_name=htmlspecialchars(strip_tags($this->customer_name));
        $this->address=htmlspecialchars(strip_tags($this->address));
        $this->order_details=htmlspecialchars(strip_tags($this->order_details));
        $this->status=htmlspecialchars(strip_tags($this->status));

        // Vincular valores
        $stmt->bindParam(":customer_name", $this->customer_name);
        $stmt->bindParam(":address", $this->address);
        $stmt->bindParam(":order_details", $this->order_details);
        $stmt->bindParam(":status", $this->status);

        if ($stmt->execute()) {
            return true;
        }
        return false;
    }

    // Actualizar un pedido
    public function update() {
        $query = "UPDATE " . $this->table_name . " SET customer_name = :customer_name, address = :address, order_details = :order_details, status = :status WHERE id = :id";
        $stmt = $this->conn->prepare($query);

        // Limpiar datos
        $this->customer_name=htmlspecialchars(strip_tags($this->customer_name));
        $this->address=htmlspecialchars(strip_tags($this->address));
        $this->order_details=htmlspecialchars(strip_tags($this->order_details));
        $this->status=htmlspecialchars(strip_tags($this->status));
        $this->id=htmlspecialchars(strip_tags($this->id));

        // Vincular valores
        $stmt->bindParam(':customer_name', $this->customer_name);
        $stmt->bindParam(':address', $this->address);
        $stmt->bindParam(':order_details', $this->order_details);
        $stmt->bindParam(':status', $this->status);
        $stmt->bindParam(':id', $this->id);

        if ($stmt->execute()) {
            return true;
        }
        return false;
    }

    // Borrar un pedido
    public function delete() {
        $query = "DELETE FROM " . $this->table_name . " WHERE id = ?";
        $stmt = $this->conn->prepare($query);

        // Limpiar id
        $this->id=htmlspecialchars(strip_tags($this->id));
        $stmt->bindParam(1, $this->id);

        if ($stmt->execute()) {
            return true;
        }
        return false;
    }
~~~

## api/index.php

~~~php
<?php
// Headers requeridos
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: OPTIONS, GET, POST, PUT, DELETE");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

// Incluir los archivos de base de datos y modelo
include_once 'config/database.php';
include_once 'models/Order.php';

// Instanciar la base de datos y el objeto Order
$database = new Database();
$db = $database->getConnection();

$order = new Order($db);

// Obtener el método de solicitud HTTP
$method = $_SERVER['REQUEST_METHOD'];

// Leer la parte de la URL después de /api
$uri = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);
$uri = explode('/', $uri);

// El primer recurso debe ser 'orders' en este caso
if ($uri[1] !== 'orders') {
    header("HTTP/1.1 404 Not Found");
    exit();
}

// El ID del pedido es opcional y puede estar presente en la URL
$orderId = isset($uri[2]) ? $uri[2] : null;

// Manejar el método HTTP
switch ($method) {
    case 'GET':
        if ($orderId) {
            // Leer un solo pedido
            $order->id = $orderId;
            if($order->readOne()){
                echo json_encode($order);
            } else {
                echo json_encode(["message" => "Pedido no encontrado."]);
            }
        } else {
            // Leer todos los pedidos
            $stmt = $order->read();
            $orderCount = $stmt->rowCount();

            if ($orderCount > 0) {
                $ordersArr = [];
                $ordersArr["records"] = [];

                while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
                    extract($row);
                    $orderItem = [
                        "id" => $id,
                        "customer_name" => $customer_name,
                        "address" => $address,
                        "order_details" => $order_details,
                        "status" => $status,
                        "created_at" => $created_at
                    ];

                    array_push($ordersArr["records"], $orderItem);
                }

                echo json_encode($ordersArr);
            } else {
                echo json_encode(["message" => "No se encontraron pedidos."]);
            }
        }
        break;
    case 'POST':
        // Crear un pedido
        $data = json_decode(file_get_contents("php://input"));

        if (!empty($data)) {
            $order->customer_name = $data->customer_name;
            $order->address = $data->address;
            $order->order_details = $data->order_details;
            $order->status = $data->status;

            if ($order->create()) {
                echo json_encode(["message" => "Pedido creado exitosamente."]);
            } else {
                echo json_encode(["message" => "No se pudo crear el pedido."]);
            }
        }
        break;
    case 'PUT':
        // Actualizar un pedido
        $data = json_decode(file_get_contents("php://input"));

        if (!empty($data) && $orderId) {
            $order->id = $orderId;
            $order->customer_name = $data->customer_name;
            $order->address = $data->address;
            $order->order_details = $data->order_details;
            $order->status = $data->status;

            if ($order->update()) {
                echo json_encode(["message" => "Pedido actualizado exitosamente."]);
            } else {
                echo json_encode(["message" => "No se pudo actualizar el pedido."]);
            }
        }
        break;
    case 'DELETE':
        // Borrar un pedido
        if ($orderId) {
            $order->id = $orderId;

            if ($order->delete()) {
                echo json_encode(["message" => "Pedido eliminado exitosamente."]);
            } else {
                echo json_encode(["message" => "No se pudo eliminar el pedido."]);
            }
        }
        break;
    default:
        // Método no permitido
        header("HTTP/1.1 405 Method Not Allowed");
        echo json_encode(["message" => "Método no permitido."]);
        break;
}

?>
~~~

## 