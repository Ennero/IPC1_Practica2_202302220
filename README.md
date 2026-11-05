# UDrive: simulación de rutas y vehículos con Java Swing

Aplicación de escritorio para cargar rutas, seleccionar vehículos, simular recorridos mediante hilos y consultar historial de distancia, combustible y fechas.

## Requisitos

JDK 21, Apache Ant y una sesión gráfica. El proyecto NetBeans está en UDrive/.

## Ejecución

Los comandos parten de la raíz del repositorio, salvo donde se indica otra terminal.

```bash
cd UDrive
ant jar
ant run
```

## Recorrido de demostración

Abrir el menú, cargar las rutas en el formato de la práctica y generar una simulación. Consultar el historial al finalizar. Las clases Ruta1 y Ruta11 implementan recorridos mediante hilos.

## Organización

Carpetas de la entrega: [`UDrive/`](UDrive/).

## Alcance y límites

La simulación no representa un servicio de mapas ni cálculo de rutas geográficas reales. Conservar los recursos de la carpeta del proyecto al ejecutar.

## Contexto y licencia

Trabajo académico o de aprendizaje conservado en el portafolio de [Enner Mendizabal](https://github.com/Ennero). Los créditos de los trabajos en grupo se conservan en sus entregas y manuales.

Consultar [LICENSE](LICENSE) para la licencia de la raíz. Las dependencias y los componentes con avisos o licencias propios conservan sus condiciones.
