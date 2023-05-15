# demo-example-spring-boot-chatgpt
Demo project for Spring Boot with Integration APIs of OpenAPI

# Spring Boot Integration APIs of OpenAI

## Requirements

1. Java - 17
2. Maven - 3.x.x > 

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/jrojas-t/demo-example-spring-boot-chatgpt.git
```

**2. Change MySQL username and password as per your MySQL installation**

open `src/main/resources/application.yaml`, and change `openai-service.api-key: YOUR_API_KEY` you need to generate an api key at [(Generate API KEY)](https://platform.openai.com/account/api-keys)

**3. Build and run the app using maven**

Finally, You can run the app by typing the following command from the root directory of the project -

```bash
mvn spring-boot:run
```

## Scheduling an Email using the /scheduleEmail API

```bash
curl --location 'http://localhost:8080/api/v1/chat' \
--header 'Content-Type: application/json' \
--data '{"question":"¿Quien pinto la mona lisa?"}'
'

# Output
{
    "id": "chatcmpl-7GVV9uhSU82zoOr2GCWrIlb5dWaWZ",
    "object": "chat.completion",
    "model": "gpt-3.5-turbo-0301",
    "created": "+4613067-04-10",
    "choices": [
        {
            "index": 0,
            "message": {
                "role": "assistant",
                "content": "La Mona Lisa fue pintada por el famoso artista italiano Leonardo da Vinci en el siglo XVI."
            }
        }
    ],
    "usage": {
        "prompt_tokens": "19",
        "completion_tokens": "22",
        "total_tokens": "41"
    }
}
```

