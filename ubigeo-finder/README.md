# ubigeo-finder

---

> ## 📄 Endpoints
> #### Consultar ubigeo
> ```bash
> echo get/ubigeo/150114 | ncat localhost 8083
> ```

> ## ¿Qué es ubigeo?
> - Código de seis dígitos que identifica a un distrito del Perú.
> - Cada par de dígitos corresponde con el departamento, provincia y distrito respectivamente.
> - Por ejemplo, el código de ubigeo `150114` representa `15`: Lima, `01`: Lima y `14`: La Molina.

> ## ⚙️ Tecnologías
> - `Lombok`: Simplifica la escritura de código repetitivo.
> - `Jackson`: Facilita la conversión entre objetos Java y formato JSON.
> - `Google Guice`: Ayuda a manejar la inyección de dependencias.

> ## 📌 Pre requisitos
> 
> > ### Instalar ncat
> > - Descargar e instalar ncat para Windows desde: https://nmap.org/download.html#windows
> > - Añadir `ncat` a las variables de entorno.
>
> > ### Construir artefacto
> > ```bash
> > mvn clean install
> > ```

