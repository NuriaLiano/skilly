---
author: "@nurialiano"
license: "Creative Commons Attribution-NonCommercial 4.0 International"
---

# Relaciones

## Crear

Las relaciones 'primary key' y 'foreign key' se pueden establecer a la vez que creas una tabla

~~~sql
CREATE TABLE pedidos (
   id SERIAL PRIMARY KEY,
   fecha DATE NOT NULL,
   producto_id INT NOT NULL,
   cantidad INT NOT NULL,
   FOREIGN KEY (producto_id) REFERENCES productos(id)
);
~~~

>:pencil: **NOTA** a diferencia de MySQL, en PostgreSQL no existe 'AUTOINCREMENT' en su lugar se utiliza el tipo de datos "SERIAL", es utilizado para crear una columna de tipo entero con una secuencia asociada que se incrementa automáticamente. La clave primaria se define como SERIAL PRIMARY KEY

## Añadir

Si se desea agregar una nueva relación a una tabla que ya existe, se utiliza el comando ALTER TABLE, especificando la tabla que se va a modificar, seguido de ADD CONSTRAINT y la especificación de la clave foránea

~~~sql
ALTER TABLE comentarios
ADD CONSTRAINT fk_comentarios_articulos
FOREIGN KEY (id_articulo)
REFERENCES articulos(id_articulo);
~~~

## Modificar

Si se desea modificar una relación existente, se utiliza el comando ALTER TABLE, especificando la tabla que se va a modificar, seguido de DROP CONSTRAINT para eliminar la restricción existente y ADD CONSTRAINT para agregar una nueva restricción.

~~~sql
-- eliminar restriccion anterior
ALTER TABLE comentarios
DROP CONSTRAINT fk_comentarios_usuarios;

--añadir la nueva
ALTER TABLE comentarios
ADD CONSTRAINT fk_comentarios_usuarios_mod
FOREIGN KEY (id_usuario)
REFERENCES usuarios(id_usuario);
~~~

## Eliminar

Si se desea eliminar una relación existente, se utiliza el comando ALTER TABLE, especificando la tabla que se va a modificar, seguido de DROP CONSTRAINT y el nombre de la restricción que se va a eliminar.

~~~sql
ALTER TABLE comentarios
DROP CONSTRAINT fk_comentarios_articulos;
~~~
