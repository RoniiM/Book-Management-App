# Book Manager App (MVCS)

A Java desktop application designed using the Model-View-Controller-Service (MVCS) architectural pattern. It provides a fluid, asynchronous Graphical User Interface for managing a catalog of books using a local SQLite database.

## Project Structure

The codebase is organized into distinct logical layers to enforce separation of concerns and maintainability:

```text
src/mvcs/
├── models/         # Data structures and domain objects (e.g., Book entity)
├── views/          # Graphical User Interface components built with Java Swing
├── controllers/    # Orchestrates data flow between Views and Services, handling UI events
├── services/       # Contains business logic and database interactions (Data Access Objects)
└── Main.java       # A command-line tester class for the backend services
```

## Features & Implementation

- **MVC Architecture**: Code is logically separated, ensuring that the UI (Views) never interacts directly with the database, and the data forms (Models) are decoupled from the business logic.
- **Asynchronous GUI Operations**: To prevent the Java Swing UI from freezing during database queries, the `BookController` utilizes custom `SwingWorker` implementations (`CreateWorker`, `FindByCodeWorker`, `FindAllWorker`, `UpdateWorker`). These workers execute long-running operations entirely on background threads. When the database operation finishes, callbacks safely update the UI components on the Event Dispatch Thread (EDT).
- **SQLite Database Integration**: A local SQLite database is utilized for persistent storage. Database operations are performed securely using `PreparedStatement` interfaces to prevent SQL injection vulnerabilities.

## Libraries Used

The project relies on external libraries located in the `lib/` directory:

- **SQLite JDBC (`sqlite-jdbc-3.51.0.0.jar`)**: The official Java Database Connectivity (JDBC) driver for interacting with SQLite databases.
- **SLF4J API (`slf4j-api-2.0.17.jar`) & JDK14 Binding (`slf4j-jdk14-2.0.17.jar`)**: Provides a Simple Logging Facade for Java, which is utilized by the SQLite driver for robust internal logging.

## Compiling and Running from Source

**Prerequisites:** Ensure you have the Java Development Kit (JDK 17 or higher) installed on your system and available in your PATH.

### 1. Compiling the Application

Open a terminal or command prompt in the root directory of the project, and create a directory for the compiled `.class` files. Use the `javac` compiler, including the `lib` directory in your classpath.

**Windows PowerShell:**
```powershell
New-Item -ItemType Directory -Force bin
javac -d bin -cp "lib\*" (Get-ChildItem -Path src -Filter *.java -Recurse | Select-Object -ExpandProperty FullName)
```

**Linux / macOS:**
```bash
mkdir -p bin
javac -d bin -cp "lib/*" $(find src -name "*.java")
```

### 2. Running the Application

Once compiled, run the Java application specifying the `bin` and `lib` directories in your classpath.

**To launch the Graphical User Interface (GUI):**

**Windows:**
```powershell
java -cp "bin;lib\*" mvcs.views.MainFrame
```

**Linux / macOS:**
```bash
java -cp "bin:lib/*" mvcs.views.MainFrame
```

*(Note: An SQLITE database file is present as a demo inside `database/`. You can use it to test the Application.)*
