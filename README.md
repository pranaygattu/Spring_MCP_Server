# Spring AI MCP Server - Shopping Cart Demo

This project demonstrates the implementation of a Model Context Protocol (MCP) server using Spring AI. It showcases how to create a simple shopping cart service that can be interacted with through AI-powered tools.

## Overview

The project implements a shopping cart service that demonstrates the integration of Spring AI's MCP server capabilities. It provides a practical example of how to create AI-tool-enabled services using Spring AI's annotation-based approach.

## Features

- Shopping cart management with concurrent operations
- AI-tool enabled endpoints for cart operations
- Thread-safe implementation using ConcurrentHashMap
- RESTful API endpoints for cart management
- Compatible with MCP clients (tested with Claude Desktop)

## Technical Stack

- Java 17
- Spring Boot 3.5.0
- Spring AI 1.0.0
- Maven

## Core Components

### ShoppingCart Service

The main service class implements the following operations:

1. **Add Items**

   - Add new items to the cart
   - Update quantities of existing items
   - Thread-safe operations

2. **Get Items**

   - Retrieve all items in the cart
   - Returns a list of items with their quantities

3. **Remove Items**
   - Remove specific quantities of items
   - Complete removal of items when quantity is not specified or exceeds available amount

## Implementation Details

The service uses Spring AI's `@Tool` annotation to expose cart operations as AI tools. This allows AI models to interact with the shopping cart through a standardized interface.

Key features of the implementation:

- Thread-safe operations using `ConcurrentHashMap`
- Input validation for item names and quantities
- Case-insensitive item name handling
- Atomic operations for updating quantities

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- Spring Boot 3.5.0

### Building the Project

```bash
mvn clean install
```

This will create a JAR file in the `target` directory that can be used with any MCP client.

### Running the Application

```bash
mvn spring-boot:run
```

### Using with Claude Desktop

This project was tested with Claude Desktop as an MCP client. To use it with Claude Desktop:

1. Build the project to generate the JAR file:

   ```bash
   mvn clean package
   ```

2. Locate the generated JAR file in the `target` directory (e.g., `demo-0.0.1-SNAPSHOT.jar`)

3. Configure Claude Desktop by modifying the `claude_desktop_config.json` file:

   ```json
   {
     "mcpServers": {
       "shopping-list-server": {
         "command": "java",
         "args": ["-jar", "PATH_TO_YOUR_JAR_FILE"]
       }
     }
   }
   ```

   Replace `PATH_TO_YOUR_JAR_FILE` with the absolute path to your JAR file.

4. Restart Claude Desktop to apply the configuration

The shopping cart service can now be used through Claude Desktop's MCP interface.

## API Usage

The service exposes the following AI tools:

1. `addItem`

   - Adds or updates items in the cart
   - Parameters: name (String), quantity (int)

2. `getItems`

   - Retrieves all items in the cart
   - Returns: List of ShoppingItem objects

3. `removeItem`
   - Removes items from the cart
   - Parameters: name (String), quantity (int)

## Project Structure

```
src/main/java/com/example/SpringAI_MCP/
├── ShoppingCart.java         # Main service implementation
└── ...                       # Other project files
```

## Contributing

Feel free to submit issues and enhancement requests!

