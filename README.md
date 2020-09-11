# MVCCrudProject
![alt text](https://github.com/lightvsi/MVCCrudProject/blob/master/Task.PNG?raw=true)

**Проект состоит из 3 модулей.**
## SpringMVCApp
**SpringMVCApp** - REST API модуль, который осуществляет взаимодействие с frontend модулем и TimeService модулем (с помощью SOAP). 
Использует:
- **Spring MVC** для обработки запросов (REST)
- **Spring Web Services** для взаимодействия с TimeService (SOAP)
- **Spring JPA** для связи с БД
- **MySQL** - СУБД
## Frontend
**Frontend** модуль реализован с помощью **Vue.js**. Отображает содержимое таблиц БД, обращаясь к REST API модулю для их получения, и время, которое REST API получает от TimeService.
## TimeService
**TimeService** модуль получает XML от REST API c указанием временной зоны и передает ответ с текущей датой и временем, которое будет отображено на frontend модуле.
**Типы передаваемых данных** генерируются из schema.xsd. Взаимодействие модулей происходит с помощью **WSDL**.
## Rest Example
Получить таблицу Goods из БД.
```http request
GET http://localhost:8080/goods
Content-Type: application/json
```

```json
{
        "serialNumber": "di83059",
        "name": "monitor",
        "address": "Berlin,Germany",
        "goodDate": "2015-01-30"
}
```
