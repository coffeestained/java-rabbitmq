
# RabbitMQ Java Rest API & React.js Dashboard

A REST API offering the ability to register and listen to multiple AMQP queues. Maven is configured to serve a React.js dashboard as well.

As per usual, feel free to yoink anything. All credits & licensing agreements in package code is up to you manage. I ask that you consider mentorship and taking time to help devs junior to you. We're all in this together and we have work to do. 💪


## API Reference

#### Register Queue

```http
  GET /api/v1/amqp/addQueue
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `queueName`      | `string` | **Required**. Queue name to be added |

#### Add Message to Queue

```http
  GET /api/v1/amqp/addMessage
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `message`      | `string` | **Required**. Message to be queued |
| `queueName`      | `string` | **Required**. Queue name to receive message |

#### Get Message(s) from Queue

```http
  GET /api/v1/amqp/getMessage
```

| Parameter   | Type     | Description                                     |
|:------------| :------- |:------------------------------------------------|
| `queueName` | `string` | **Required**. Queue name to retrieve message(s) |
| `count`     | `string` | **Optional**. Defaults to 1                     |

## Installation

Coming soon.

## Build & Deploy

Coming soon.

## Testing

Coming soon.
