📝 Manual de Usuario – Aplicación Ranking Deportistas
📌 Descripción General
La aplicación Ranking Deportistas permite gestionar un listado de deportistas con su nombre, edad, deporte y calificación (rating del 1 al 5). Está pensada para ser sencilla, clara y útil en entornos educativos o de gestión deportiva básica.

🚀 Requisitos para Ejecutar
Tener Java 8 o superior instalado.

Ejecutar la aplicación desde un entorno que soporte ventanas gráficas (no en consola).

Doble clic en el .jar (si lo generaste) o ejecutar con:

bash
Copiar código
java src.net.salesianos.ranking.App
🖥️ Interfaz Principal
Al abrir la aplicación, se muestra una ventana con:

Un área central de texto donde se visualiza información.

Un panel con 5 botones:

Añadir

Editar

Eliminar

Mostrar Todo

Salir

🧩 Funcionalidades
➕ Añadir Deportista
Haz clic en “Añadir”.

Introduce:

Nombre

Edad (número entero)

Deporte

Rating (de 1 a 5)

Si los datos son válidos, el deportista se añadirá a la lista.

⚠️ El rating debe ser un número entre 1 y 5. De lo contrario, se mostrará un error.

✏️ Editar Deportista
Haz clic en “Editar”.

Introduce el nombre del deportista que deseas editar.

Ingresa los nuevos valores para edad, deporte y rating.

Si el deportista existe, se actualizarán sus datos.

🗑️ Eliminar Deportista
Haz clic en “Eliminar”.

Introduce el nombre del deportista.

Si existe, será eliminado.

📋 Mostrar Todos
Haz clic en “Mostrar Todo” para ver la lista completa de deportistas ordenados por calificación (de mayor a menor).

Se mostrarán los detalles de cada uno en el área central.

❌ Salir
Haz clic en “Salir” para cerrar la aplicación de forma segura.

🛠️ Observaciones Técnicas
Los datos no se guardan entre ejecuciones. Al cerrar la app, la lista se pierde.

La validación del rating se realiza desde la interfaz gráfica.

No se permite añadir deportistas con campos vacíos o inválidos.