## API Reference

#### Register Queue

```http
  GET /api/v1/amqp/addQueue
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `queueName`      | `string` | **Required**. Queue name to be added |

#### Get item

```http
  GET /api/v1/amqp/message
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `message`      | `string` | **Required**. Message to be queued |
| `queueName`      | `string` | **Required**. Queue name to receive message |

