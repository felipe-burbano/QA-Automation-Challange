# Servicio o endpoint: https://quasar-qa-challenge.prodeng-playground.mercadolibre.com/topsecret_split/{satellite_name}
# Tipo de pruebas contempladas: Happy-Path, Pruebas Funcionales, Pruebas Exploratorias, Particionamiento de equivalencia, Valores al limite, Prueba de caja negra, Pruebas de Performace
# Casos de pruebas realizados en lenguaje: Gherkin
# Herramientas: Jmeter, Postman
# Automatización backend: Si
# Resultado: Exitoso

# language: es

Característica: Obtener el mensaje secreto y posición de cada satelite
  YO como controlador de satelite
  QUIERO obtener la posición y mensaje exacto recibido desde la nave
  PARA para transmitir la información correctamente

  Esquema del escenario: Obtener el mensaje y posición exacto de cada satelite
    Dado tengo la disponibilidad del satelite
    Cuando se envia el nombre del satelite <SATELITE>
    Entonces obtengo las coordenadas y el mensaje

    Ejemplos:
      | SATELITE     |
      | kenobi       |
      | skywalker    |
      | sato         |