# Spark Web

### Despliegue Heroku API Client(Java)

[![Heroku](https://www.herokucdn.com/deploy/button.png)](https://ejerciciospark.herokuapp.com/Facadea?periodo=DAILY&simbolo=MSFT)

### Despliegue Heroku Web Client(JavaScript)

[![Heroku](https://www.herokucdn.com/deploy/button.png)](https://front-spark.herokuapp.com/)

### GitHub Web Client

https://github.com/julitom1/frontSpark

## Descripción


## Diseño

### Diagrama de Clases

![](imgs/DiagramaDeClases.JPG)

### Diagrama de Despliegue

![](imgs/DiagramaDeDespliegue.JPG)

## Memoria Cache

Son HashMapConcurrent que mantienen datos guardados de las query que se hayan hecho, cuando se guarda un dato este dura en la cache durante 5 minutos, luego de ello, se borra de la cache (Esto es por si actualizan la API externa).

![](imgs/memoriaCache.JPG)

## Extensibilidad

Esta API es fácil de extender

## Autor

 * Yarit Yajanny Villalobos
