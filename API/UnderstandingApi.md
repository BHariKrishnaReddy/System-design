# API

This document explains commonly used API and communication technologies used in modern software systems:

- RESTful API  
- SOAP  
- gRPC  
- GraphQL  
- WebSocket  

---

## 1. RESTful API

### What is RESTful API
REST (Representational State Transfer) is an architectural style for designing networked applications.  
RESTful APIs use HTTP to perform operations on resources identified by URLs, typically exchanging data in JSON format.

---

### Design Principles
REST follows these core constraints:

1. **Client–Server Separation**  
   Client and server are independent, improving scalability and flexibility.

2. **Statelessness**  
   Each request contains all required information. The server does not store client session state.

3. **Uniform Interface**  
   Resources are identified by URIs and accessed using standard HTTP methods:
   - GET (read)
   - POST (create)
   - PUT / PATCH (update)
   - DELETE (remove)

4. **Resource-Based**  
   Everything is treated as a resource.

5. **Cacheability**  
   Responses can be cached to improve performance.

---

### When Should We Use REST
- CRUD-based applications  
- Public APIs  
- Web and mobile applications  
- Simple microservice communication  
- When simplicity and readability matter

---

### How Can We Use It
Clients send HTTP requests to endpoints, and servers respond with JSON.

Example:
* GET /api/users/123
* POST /api/orders


---

### Drawbacks
- Over-fetching or under-fetching data  
- No built-in real-time support  
- Multiple endpoints for related data  
- Weak contract enforcement compared to gRPC or SOAP  

---

## 2. SOAP

### What is SOAP
SOAP (Simple Object Access Protocol) is a strict protocol for exchanging structured information in web services.  
It relies on XML and supports enterprise-level communication.

---

### Design Principles
1. **Strict Contract**  
   Uses WSDL (Web Services Description Language) to define services and data types.

2. **Protocol-Based**  
   Works over HTTP, HTTPS, SMTP, etc.

3. **Built-in Standards**  
   Supports security (WS-Security), transactions, and reliable messaging.

---

### When Should We Use SOAP
- Banking and financial systems  
- Government and enterprise applications  
- Legacy system integration  
- When strong security and reliability are mandatory  

---

### How Can We Use It
Clients send XML-based SOAP requests and receive XML responses.  
WSDL is used to generate client and server code automatically.

---

### Drawbacks
- Very verbose XML  
- Slower performance  
- Harder to debug  
- Poor browser support  
- Overkill for simple APIs  

---

## 3. gRPC

### What is gRPC
gRPC is a high-performance Remote Procedure Call (RPC) framework developed by Google.  
It uses HTTP/2 and Protocol Buffers (Protobuf) for binary communication.

---

### Design Principles
1. **Contract-First Design**  
   APIs are defined using `.proto` files.

2. **Strong Typing**  
   Message structures are strictly enforced.

3. **Binary Communication**  
   Smaller payloads and faster serialization.

4. **HTTP/2 Features**  
   Multiplexing, streaming, and header compression.

---

### When Should We Use gRPC
- Microservice-to-microservice communication  
- Low-latency, high-throughput systems  
- Internal APIs  
- Polyglot environments  

---

### How Can We Use It
- Define services and messages in `.proto` files  
- Generate client and server code  
- Call remote methods like local functions  

---

### Drawbacks
- Not human-readable  
- Limited browser support  
- Requires tooling and setup  
- Not ideal for public APIs  

---

## 4. GraphQL

### What is GraphQL
GraphQL is a query language and runtime that allows clients to request exactly the data they need from an API.

---

### Design Principles
1. **Single Endpoint**  
   All queries go through one endpoint.

2. **Client-Driven Queries**  
   Clients define the response structure.

3. **Strongly Typed Schema**  
   Data types and relationships are explicitly defined.

4. **Hierarchical Data Fetching**  
   Related data can be fetched in a single request.

---

### When Should We Use GraphQL
- Complex data relationships  
- Frontend-heavy applications  
- Mobile apps with bandwidth constraints  
- APIs with frequently changing requirements  

---

### How Can We Use It
- Define a schema with queries and mutations  
- Clients send queries specifying required fields  
- Server resolves and returns structured responses  

---

### Drawbacks
- Complex server implementation  
- Difficult caching  
- Risk of expensive queries  
- Overkill for simple CRUD use cases  

---

## 5. WebSocket

### What is WebSocket
WebSocket is a full-duplex, persistent communication protocol over a single TCP connection.  
It enables real-time, bidirectional communication.

---

### Design Principles
1. **Persistent Connection**  
   Connection remains open.

2. **Full-Duplex Communication**  
   Both client and server can send data at any time.

3. **Low Latency**  
   Eliminates repeated HTTP request overhead.

---

### When Should We Use WebSocket
- Chat applications  
- Live notifications  
- Online gaming  
- Stock price updates  
- Real-time collaboration tools  

---

### How Can We Use It
- Client opens a WebSocket connection  
- Server pushes data without client polling  
- Messages flow continuously  

---

### Drawbacks
- Stateful connections  
- Harder to scale  
- Requires connection lifecycle management  
- Not suitable for simple request–response APIs  

---

## Summary Comparison

| Technology | Best Use Case | Key Strength |
|---------|---------------|--------------|
| REST | General APIs | Simplicity |
| SOAP | Enterprise systems | Security & contracts |
| gRPC | Microservices | Performance |
| GraphQL | Frontend-driven APIs | Flexible queries |
| WebSocket | Real-time apps | Live communication |
