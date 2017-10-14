# WildPi-JSON

This is a simple JSON library for Java. It started out as a programming exercise, but has grown into a tool that I like to use for some of my other projects.

## Why use WildPi-JSON?

There are already several robust JSON libraries avaible for Java like Jackson and GSON, so why make another one? WildPi-JSON was created for two main reason:
1. I thought it would be fun to write my own JSON library
2. I wanted a JSON library which would handle the syntax of casting JSON values to Java types automatically

## Getting Started

The needs and use cases which initiated the creation of WildPi-JSON revolved around my need to parse incoming strings of JSON. To do so all that is needed a single call:

```java
JSONObject object = JSONParser.parse("{ \"key\": \"value\" }");
```
