---
description: Actualiza el README.md según los avances del curso (estructura, aprendizajes recientes y generales)
---

Actualiza el `README.md` de la raíz del repositorio para que refleje el estado actual del curso. Trabaja siempre sobre el README existente, no lo reescribas desde cero: conserva su tono, idioma (español) y formato.

## 1. Averigua qué ha cambiado

- Lee el `README.md` actual.
- Mira `git log --oneline`, `git status` y `git diff` para ver los avances desde la última actualización del README (`git log -1 --format=%H -- README.md`).
- Recorre las carpetas de proyecto (`shoplab*/`): nuevas carpetas por capítulo, clases nuevas en `src/main/java/shoplab/` y `ejercicios/`, tests, cambios en `build.gradle` y `application.properties`.
- Consulta `docs/design-patterns.pdf` (con `pdftotext -layout`, volcando a un fichero en el scratchpad) solo para saber qué capítulo/ejercicios corresponden y nombrar bien los conceptos. No copies texto del libro.
- Deduce el ejercicio o capítulo en el que va el usuario por los mensajes de commit y el código. **No des por hecho nada que no esté en el código**: si un ejercicio no está hecho, no cuentes sus aprendizajes como adquiridos.
- Comprueba si el proyecto vivo compila (`./gradlew compileJava` en la carpeta que corresponda) y refleja el resultado real en la sección de estado.

## 2. Qué actualizar en el README

1. **Estructura y "Cómo funciona"**: si hay carpetas, clases, endpoints o convenciones nuevas (o que han dejado de existir), cambia la tabla de estructura y la descripción del dominio. Si la forma del proyecto ha cambiado, adapta las secciones que haga falta.
2. **"Qué se puede probar por ahora"**: añade o corrige comandos, endpoints y `*Check` ejecutables. Marca como "estable" el último estado que funcione y como "en curso" el que no. Comprueba los comandos que puedas ejecutar con seguridad (`./gradlew test`, `compileJava`); no arranques servidores a menos que sea necesario.
3. **"Aprendizajes del último capítulo"**: reemplázalo por el capítulo en curso o el último completado. Indica qué ejercicios están hechos y cuáles faltan. Si el capítulo anterior ya está completo, mueve sus aprendizajes relevantes al apartado general.
4. **"Aprendizajes del curso hasta ahora"**: añade (sin duplicar) los conceptos nuevos de los capítulos completados, con una subsección por capítulo. Si un capítulo está a medias, déjalo solo en la sección de lo más reciente.
5. **"Próximos pasos"**: actualízalo con lo que falta realmente.

## 3. Reglas

- Sé honesto con el estado: si algo no compila o está sin terminar, dilo.
- Sé conciso: viñetas cortas, un concepto por línea, sin relleno.
- No toques código fuente ni hagas commits; solo edita `README.md`.
- Al terminar, resume en pocas líneas qué has cambiado y señala cualquier suposición que hayas hecho sobre el progreso del usuario.

$ARGUMENTS
