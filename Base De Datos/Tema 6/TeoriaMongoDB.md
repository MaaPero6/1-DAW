# MongoDB (DAW - TEMA 6)
## BLOQUE 1: TEORÍA EXPRÉS 
### 1. SQL (Relacional) vs NoSQL (No Relacional)
| Característica | SQL (Relacional) | NoSQL (MongoDB) |
| --- | --- | --- |
| **Estructura** | Estricta (Tablas con filas y columnas fijas) | Dinámica (Documentos JSON flexibles)
| **Duplicacion** | Diseñado para evitar duplicados(Normalizacion) | Permite redundancia para agilizar consultas
| **Prioridad** | Integridad y seguridad de los datos | Velocidad de lectura/escritura y escalabilidad
| **Uso comun** | Sector empresarial, financiero, contabilidad | Redes sociales, apps en tiempo real, Big Data

### 2. Equivalencias de vocabulario
- **Base de datos** -> Base de datos (Database)
- **Tabla** -> Colección (Collection)
- **Fila/Registro** -> Documento
- **Columna** -> Campo

### 3. JSON vs. BSON
- **JSON (JavaScript Object Notation)**: Es el formato de texto plano legible por humanos que usas para escribir los documentos { "campo": "valor" }. No soporta tipos de datos avanzados como fechas nativas.
- **BSON (Binary JSON)**: Es el formato binario que usa MongoDB internamente. Es más eficiente, ocupa menos espacio y permite guardar más tipos de datos (fechas, binarios, números exactos, etc.)

## BLOQUE 2: COMANDOS BÁSICOS EN mongosh
Para moverte por la terminal, estos comandos son obligatorios. Se ejecutan directamente en la shell:
```javascript
show dbs // Muestra todas las bases de datos con contenido.
use cine_db // Se cambia a la base de datos cine_db (si no existe, la crea en el momento en que insertes el primer documento).
db // Te dice en qué base de datos estás posicionado actualmente.
show collections // Muestra las colecciones de la base de datos activa.
db.createCollection('peliculas') // Crea manualmente una colección vacía.
db.peliculas.drop() // Elimina por completo la colección peliculas.
db.dropDatabase() // Elimina la base de datos activa (¡cuidado con esto!).
cls // Limpia la pantalla de la consola.
```

## BLOQUE 3: CONSULTAS DE DOCUMENTOS (find)
La estructura de una consulta en MongoDB siempre es: 
`db.coleccion.find( { <Filtro> }, { <Proyección> } )`

### 1. El Filtro y los Operadores de Comparación
Si quieres buscar registros específicos, usas objetos con operadores:
```javascript
// Igualdad: por defecto o de forma explícita usando $eq:
db.peliculas.find({ "director": "Christopher Nolan" })
db.peliculas.find({ "director": { $eq: "Christopher Nolan" } })

// Desigualdad ($ne): Películas que NO hayan ganado un Oscar:
db.peliculas.find({ "oscar": { $ne: true } })

// Mayor que ($gt) / Mayor o igual ($gte): Estrenadas en 2010 o después:
db.peliculas.find({ "año": { $gte: 2010 } })

// Menor que ($lt) / Menor o igual ($lte): Menos de 50 habitantes:
db.zips.find({ "pop": { $lt: 50 } })

// Contenido en un grupo ($in): Códigos postales de ciudades que sean o 'SAN DIEGO' o 'ALLEN':
db.zips.find({ "city": { $in: ["SAN DIEGO", "ALLEN"] } })

// No contenido en un grupo ($nin): Que no pertenezcan a esos estados.
```

### 2. Operadores Lógicos ($and, $or, $not, $nor)
```javascript
// $and (Y lógico): Si pones varios campos con comas dentro de { }, se aplica un AND implícito.
// Ejemplo: Del género "Sci-Fi" Y puntuación superior a 8.6:
db.peliculas.find({ "genero": "Sci-Fi", "puntuacion": { $gt: 8.6 } })

// Forma explícita con $and (útil si tienes que repetir el mismo campo):
db.peliculas.find({ $and: [ { "genero": "Sci-Fi" }, { "puntuacion": { $gt: 8.6 } } ] })

// $or (O lógico): Devuelve documentos que cumplan al menos una condición. Va con un array.
// Ejemplo: Ciudad "SAN DIEGO" o estado "TX":
db.zips.find({ $or: [ { "city": "SAN DIEGO" }, { "state": "TX" } ] })

// $not (Negación): Niega un operador.
// Ejemplo: Viajes que no duren más de 3600 segundos:
db.trips.find({ "tripduration": { $not: { $gt: 3600 } } })

// $nor (Ni lo uno ni lo otro): Muy útil para rangos excluyentes o exclusiones múltiples.
// Ejemplo: Documentos que no tengan menos de 5,000 habitantes ni más de 1,000,000:
db.zips.find({ $nor: [ { "pop": { $lt: 5000 } }, { "pop": { $gt: 1000000 } } ] })
```

### 3. Proyecciones (Elegir qué campos mostrar)
Sirve para no saturar la pantalla mostrando solo los campos que te interesan.
- `1` para mostrar el campo.
- `0` para ocultarlo.

> [!IMPORTANT]
> **Regla de oro de las Proyecciones:** No puedes mezclar `1` y `0` en la misma proyección, excepto con el campo `_id`, que se muestra por defecto a menos que lo apagues explícitamente con `_id: 0`.

```javascript
// Ejemplo de proyección: Obtener solo el código postal (zip) sin mostrar el _id:
db.zips.find({ "city": "ALLEN" }, { "zip": 1, "_id": 0 })
```

### 4. Modificadores del Cursor (sort, limit, skip, countDocuments)
Estos métodos se encadenan al final de la consulta `.find()`:
```javascript
// countDocuments() o count(): Devuelve el número de documentos coincidentes.
db.zips.find({ "city": "SAN DIEGO" }).count()

// limit(N): Devuelve solo los primeros N resultados.
// skip(N): Salta los primeros N resultados.
// sort({ campo: 1 }): Ordena los resultados. Use 1 para orden ascendente y -1 para descendente.

// Ejemplo: Los 5 viajes más recientes, saltando los primeros 10 resultados:
db.trips.find().sort({ "start time": -1 }).skip(10).limit(5)
```

### 5. Expresiones Regulares ($regex)
Para buscar textos que contengan palabras específicas o sigan patrones.
```javascript
// Contiene "BEACH" (cualquier posición):
db.zips.find({ "city": { $regex: "BEACH" } })

// Empieza por "BEACH":
db.zips.find({ "city": { $regex: "^BEACH" } })

// Acaba en "BEACH":
db.zips.find({ "city": { $regex: "BEACH$" } })

// Ignorar mayúsculas/minúsculas ($options: "i"):
db.zips.find({ "city": { $regex: "beach", $options: "i" } })
```

### 6. Consultas sobre Arrays y Objetos Anidados
```javascript
// Arrays simples: Si buscas un elemento dentro de un array, búscalo como si fuera un campo normal:
// (Buscará cualquier documento donde "Drama" esté dentro del array "genero")
db.peliculas.find({ "genero": "Drama" })

// Arrays exactos: Si buscas una coincidencia exacta de elementos en el mismo orden:
db.movies.find({ "languages": ["English", "German"] })

// Operador $all: Si buscas que contenga todos los elementos listados sin importar el orden:
db.movies.find({ "languages": { $all: ["English", "French"] } })
```
> [!WARNING]
> **Objetos anidados (Notación de punto):** ¡Obligatorio usar comillas si usas el punto para acceder a subcampos! De lo contrario dará error de sintaxis.
> ```javascript
> // Criterio directo (requiere comillas en el campo con punto):
> db.usuarios.find({ "domicilio.cp": "28001" })
> 
> // Criterio con operador dentro de un objeto (requiere comillas en ambos):
> db.usuarios.find({ "domicilio.cp": { $eq: "28001" } })
> ```

## BLOQUE 4: INSERTAR, BORRAR Y ACTUALIZAR (CRUD)

### 1. Inserción de documentos
```javascript
// db.coleccion.insertOne({ ... }): Inserta un único documento.
db.peliculas.insertOne({ "title": "Inception", "director": "Christopher Nolan" })

// db.coleccion.insertMany([ { ... }, { ... } ]): Inserta varios usando un array de objetos.
db.peliculas.insertMany([
    { "title": "Interstellar", "director": "Christopher Nolan" },
    { "title": "Memento", "director": "Christopher Nolan" }
])
```

### 2. Eliminación de documentos
```javascript
// db.coleccion.deleteOne({ <Filtro> }): Elimina el primer documento que cumpla la condición.
db.zips.deleteOne({ "city": "ALLEN" })

// db.coleccion.deleteMany({ <Filtro> }): Elimina todos los documentos que coincidan.
db.zips.deleteMany({ "pop": { $lt: 10 } })

// db.coleccion.findOneAndDelete({ <Filtro> }): Borra el documento y te lo devuelve en consola.
db.zips.findOneAndDelete({ "zip": "03206" })
```

### 3. Reemplazar vs Actualizar
> [!WARNING]
> Diferencia crucial de examen:
>
> `replaceOne` **BORRA** todo el documento original (menos el `_id`) y lo cambia por el nuevo objeto.
>
> `updateOne` **CONSERVA** el documento y solo modifica los campos que le indiques con operadores.
```javascript
// replaceOne: Sustituye el documento entero con ID 1 por este nuevo objeto.
db.peliculas.replaceOne({ _id: 1 }, { "nuevoCampo": "valor" })

// updateOne: Modifica solo los campos indicados sin alterar el resto del documento.
db.peliculas.updateOne({ _id: 1 }, { $set: { "puntuacion": 9 } })
```

### 4. Operadores de Actualización clave (updateOne / updateMany)
```javascript
// $set: Modifica el valor de un campo existente o lo crea si no existía.
db.zips.updateOne({ "zip": "03206" }, { $set: { "provincia": "Alicante" } })

// $unset: Elimina un campo por completo. El valor que le pongas da igual (se suele usar "" o 1).
db.zips.updateOne({ "zip": "03206" }, { $unset: { "loc": "" } })

// $inc: Incrementa o decrementa un campo numérico en el valor indicado.
db.zips.updateMany({ "state": "España" }, { $inc: { "pop": 666 } })   // Suma 666
db.zips.updateMany({ "state": "España" }, { $inc: { "pop": -100 } })  // Resta 100

// $mul: Multiplica un campo numérico por un factor.
db.productos.updateOne({ _id: 2 }, { $mul: { "precio": 1.10 } })     // Sube un 10% el precio

// $rename: Cambia el nombre físico de un campo.
db.zips.updateMany({ "provincia": "Alicante" }, { $rename: { "prov": "provincia" } })

// $currentDate: Guarda la fecha o timestamp actual en el campo que digas.
db.movies.updateOne({ "title": "Macbeth" }, { $currentDate: { "last_updated": true } })
```

## BLOQUE 5: MONGO DB COMPASS (Ubicación en la interfaz)
Esta es la "chuleta visual" de dónde va cada cosa:
- Conexión: Al abrir Compass, te pedirá una URI. Si trabajas en local, pega `mongodb://localhost:27017` o `mongodb://127.0.0.1:27017` y dale a Connect.

- Estructura Izquierda: Verás el árbol de bases de datos. Al hacer clic en una BD se despliegan sus colecciones.

### La Barra de Consultas
Cuando entras en una colección, en la pestaña Documents verás una barra de búsqueda con estos campos listos para rellenar con tus objetos de consulta:
| Campo en Compass | ¿Qué se escribe dentro? | Ejemplo de formato |
| :--- | :--- | :--- |
| **Filter** | La condición de búsqueda (El primer objeto del `.find()`) | `{ "city": "SAN DIEGO" }` |
| **Project** | La proyección para elegir campos (El segundo objeto) | `{ "zip": 1, "_id": 0 }` |
| **Sort** | El criterio de ordenación (`1` asc, `-1` desc) | `{ "pop": -1 }` |
| **Collation** | Se deja vacío por defecto (reglas específicas de idioma) | *Vacío* |
| **Skip** | El número de documentos que quieres saltar | `10` |
| **Limit** | El límite máximo de resultados a mostrar en pantalla | `5` |