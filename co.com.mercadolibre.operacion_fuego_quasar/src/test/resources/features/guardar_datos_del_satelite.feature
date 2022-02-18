# Servicio o endpoint: https://quasar-qa-challenge.prodeng-playground.mercadolibre.com/topsecret_split/{satellite_name}
# Tipo de pruebas contempladas: Happy-Path, Pruebas Funcionales, Pruebas Exploratorias, Particionamiento de equivalencia, Valores al limite, Prueba de caja negra, Pruebas de Performace
# Casos de pruebas realizados en lenguaje: Gherkin
# Herramientas: Jmeter, Postman
# Resultado: Exitoso

# language: es

Característica: Almacenar el mensaje secreto y posición de cada satelite
  YO como controlador de satelite
  QUIERO guardar la posición y mensaje secreto recibido desde la nave
  PARA para transmitir el la información correctamente

  Esquema del escenario: Guardar el mensaje secreto y posición correcto en cada satelite
    Dado que se ha enviado el mensaje hacia el satelite  <SATELITE>
    Cuando se envia la distancia <DISTANCIA> y el mensaje secreto <MENSAJE>
    Entonces la informacion se almacena correctamente

    Ejemplos:
      | SATELITE  | DISTANCIA | MENSAJE                     |
      | kenobi    | 0         | ["este","","","mensaje",""] |
      | kenobi    | 0.1       | ["este","","","mensaje",""] |
      | kenobi    | 142.9     | ["este","","","mensaje",""] |
      | kenobi    | 142.9     | ["este","","","mensaje",""] |
      | kenobi    | 9999.99   | ["este","","","mensaje",""] |
      | kenobi    | 500       | ["este","","","mensaje",""] |
      | kenobi    | -240      | ["este","","","mensaje",""] |
      | skywalker | 0         | ["","es","","","secreto"]   |
      | skywalker | 0.1       | ["","es","","","secreto"]   |
      | skywalker | 142.9     | ["","es","","","secreto"]   |
      | skywalker | 142.9     | ["","es","","","secreto"]   |
      | skywalker | 9999.99   | ["","es","","","secreto"]   |
      | skywalker | 500       | ["","es","","","secreto"]   |
      | skywalker | -312      | ["","es","","","secreto"]   |
      | sato      | 0         | ["este","","un","",""]      |
      | sato      | 0.1       | ["este","","un","",""]      |
      | sato      | 142.9     | ["este","","un","",""]      |
      | sato      | 142.9     | ["este","","un","",""]      |
      | sato      | 9999.99   | ["este","","un","",""]      |
      | sato      | 500       | ["este","","un","",""]      |
      | sato      | -153.22   | ["este","","un","",""]      |