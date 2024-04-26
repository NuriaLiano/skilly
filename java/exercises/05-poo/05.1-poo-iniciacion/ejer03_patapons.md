# Ejercicio de arrays. Aventura de los Patapons

## Objetivo

Desarrollar un programa en Java que simule un nivel básico del videojuego Patapon, donde el jugador tiene el control de un ejército de Patapons y debe coordinarlos para superar obstáculos y derrotar enemigos. Utilizando arrays para gestionar las unidades de Patapons y los enemigos en el campo de batalla, el jugador debe organizar sus tropas, atacar y defenderse para alcanzar el final del nivel.

## Descripción del ejercicio

El jugador dispone de un ejército de Patapons, cada uno con diferentes roles (Atacante, Defensor, y Soporte). El objetivo es atravesar un campo de batalla donde se encuentran diferentes enemigos distribuidos a lo largo del camino. El programa debe permitir al jugador:

1. Organizar su ejército de Patapons: El jugador podrá ordenar su ejército antes de iniciar el combate, utilizando un array para almacenar los Patapons según su orden de batalla.
2. Avanzar por el campo de batalla: El jugador avanza automáticamente por el campo, encontrando enemigos que están almacenados en otro array. Cada enemigo se encuentra en una posición específica del campo de batalla.
3. Combatir enemigos: Al encontrarse con un enemigo, el jugador debe utilizar su ejército para combatir. Cada tipo de Patapon tiene un efecto específico (atacar, defender, curar), y el resultado del combate se determina por la composición del ejército del jugador y el tipo de enemigo enfrentado.
4. Finalizar el nivel: El juego termina cuando el jugador ha derrotado a todos los enemigos en el campo de batalla o cuando todos sus Patapons han sido derrotados.

## Requisitos

- Uso de Arrays: Utilizar arrays para gestionar el ejército de Patapons del jugador y los enemigos en el campo de batalla.
- Una única clase Main: Todo el código debe estar contenido en una única clase Main.
- Interacción básica: El programa debe ofrecer una interacción básica con el usuario, permitiendo organizar el ejército de Patapons antes del combate y mostrando mensajes relevantes durante el avance en el campo de batalla y los combates
