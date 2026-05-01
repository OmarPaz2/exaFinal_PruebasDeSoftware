@checkout
  Feature: Proceso de compra

    Scenario: Completar compra existosamente
      Given que el usuario tiene productos en el carrito
      When procede al checkout
      And ingresa los datos de envio
      And confirma la compra
      Then deberia ver el mensaje de compra exitosa

    Scenario: Carrito vacio no permite checkout
      Given que el usuario tiene el carrito vacio
      When intenta proceder al checkout
      Then deberia ver mensaje de carrito vacio

    Scenario: No permite completar compra sin direccion de envio
      Given que el usuario tiene productos en el carrito
      When procede al checkout
      And no ingresa la direccion de envio
      And confirma la compra
      Then deberia ver un mensaje indicando que la direccion es obligatoria