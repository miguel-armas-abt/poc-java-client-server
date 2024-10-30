# REDES CON TCP

---

## 1. Diccionario

### Ubigeo
Código de seis dígitos que identifica a un distrito del Perú. Cada par de dígitos corresponde con el departamento, 
provincia y distrito respectivamente. Por ejemplo, el código de ubigeo `150114` representa `15`: Lima, `01`: Lima y `14`: La Molina.

---

## 2. Pre requisitos

### Instalar ncat
- Descargar e instalar ncat para Windows desde: https://nmap.org/download.html#windows
- Añadir `ncat` a las variables de entorno.

---

## 3. Componentes y operaciones

### contact-data

| Operación            | Descripción                                             |
|----------------------|---------------------------------------------------------|
| `contact-data/{dni}` | Recupera los datos de contacto asociados a un cliente.  |


### ubigeo-finder

| Operación             | Descripción                    |
|-----------------------|--------------------------------|
| `ubigeo/{ubigeoCode}` | Recupera los datos del ubigeo. |

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
