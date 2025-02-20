# Hoja de trabajo 4 - Patrones de diseño

---

## Dependencias

- Apache Maven

**Instalación**

```bash
mvn install
```

---

## Compilación

```bash
mvn package
```

## Ejecución 

```bash
mvn exec:java '-Dexec.mainClass="com.api.App"'
```

## Test

```bash
mvn -Dtest=AppTest test
```

## Diagram Class

![image](https://github.com/user-attachments/assets/c8d7e7bd-9afb-4eb5-a223-bc6597e53fef)


## Preguntas del PDF

Revise que ventajas / desventajas hay al utilizar el patrón Singlenton en general, ya que su comportamiento es muy
similar a una variable global. ¿Cree que su uso es adecuado en este programa? Conteste en un documento PDF
   - R: Es adecuado en ciertas medida nada más, por ejemplo para comprobar que la clase postfix no instancie más de una vez al Stack, asegurando un mejor control de memoria e instancias. 
     Pero en otros casos solo retrasaría las pruebas unitarias por ejemplo por lo que hay que usarlo nada más cuando sea estrictamente necesario.



