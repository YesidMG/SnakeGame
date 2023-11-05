# SnakeGame
Este proyecto es una representacion del juego de la culebrita con los cambios requeridos añadidos

## Autor
- Yesid Alejandro Martinez

## Clase Main
paquete View.ControllFrame
clase MyFrame

## Ruta de configuracion
data/levels.json

## Ruta de partitura
data/history.json

## Objetos
El alimento o el objeto que la serpiente consume para crecer es el representado por un punto rojo, los cuadrados negros son las barreras

## Estrategia de niveles
Los niveles se diferencian en 3 niveles, y se diferencian por el tiempo de aparicion de la comida, de la barrera y la velocidad inicial de la serpiente, siendo entre mas arriba el nivel mas rapido empieza y alcanza una velocidad maxima de 50+la velocidad inicial

## Estrategia de crecimiento de velocidad
Cada vez que la serpiente crece una unidad se aumenta una unidad en su velocidad, su velocidad aumenta hasta un maximo de 50 unidades

## Estrategia de puntaje
El score se define de la sigioente forma, cada comida tiene un tiempo de espera hasta generar una nueva, el escore aumenta en 1*tiempo restante de la comida
Ejemplo: score += 1*(consumio la comida 3 segundos antes de que desaparezca) 


