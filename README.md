# CLIENTE-SERVIDOR CON TCP
Este proyecto implementa una comunicación cliente-servidor mediante TCP.

---

### contact-data

| Operación                                               | Endpoint             |
|---------------------------------------------------------|----------------------|
| Recuperar los datos de contacto asociados a un cliente. | `contact-data/{dni}` |

---

## 4. Diagrama de secuencias

<img src="./images/sequences-diagram.png" width="700" height="400">

---

## 5. Instrucciones de ejecución
- Instalar cada uno de los componentes con `mvn clean install`
- Iniciar cada uno de los componentes desde sus respectivas clases Application.
- Para consultar a `ubigeo-finder`, puede ejecutar el siguiente comando en la GitBash:

```sh
  echo ubigeo/150114 | ncat localhost 8080
```

- Para consultar a `contact-data`, puede ejecutar el siguiente comando en la GitBash:

```sh
  echo contact-data/76517368 | ncat localhost 8081
```

