# WildPi-JSON

This is a simple JSON library for Java. It started out as a programming exercise, but has grown into a tool that I like to use for some of my other projects.

### Table of Contents
1. [Why use WildPi-JSON](#why-use-wildpi-json)
2. [Getting Started](#getting-started)
3. [Getting Fancy - Parse/Serialize JSON to java.util.Map](getting-fancy---parseserialize-json-to-javautilmap)

## Why use WildPi-JSON?

There are already several robust JSON libraries avaible for Java like Jackson and GSON, so why make another one? WildPi-JSON was created for two main reason:
1. I thought it would be fun to write my own JSON library
2. I wanted a JSON library which would handle the syntax of casting JSON values to Java types automatically

## Getting Started

The needs and use cases which initiated the creation of WildPi-JSON revolved around my need to parse incoming strings of JSON. To do so all that is needed a single call:

```java
JSONObject object = JSONParser.parse("{ \"key\": \"value\" }");
```
To get the original string of JSON back simply call the `serialize` method:

```java
JSONObject object = JSONParser.parse("{ \"key\": \"value\" }");
System.out.println(object.serialize());
```
WildPi-JSON can "JSONify" Java objects, but it does not use annotations or reflection to automatically determine which members of an object should be included. The difference originates from my projects where I originally developed WildPi-JSON. In these projects the JSON produced by needed different properties to be included or excluded based on runtime conditions. To allow for this each object implements the `ToJSONable` interface which is used in a similar fashion to the `Object#toString` method. As a result to "JSONify" a Java object you can use `ToJSONable#asJSON`. However, this is not a requirement. Below is one way in which  the "JSONification" of a Java object could be constructed using WildPi-JSON

```java
Point tpr = new Point(true);
Point xyz = new Point(false);

JSONObject tprJSON = tpr.asJSON();
JSONObject xyzJSON = xyz.asJSON();

tpr.getKeySet().contains("theta");  //will return true;
xyz.getKeySet().contains("theta");  //will return false;

tpr.getKetSet().contains("x");  //will return false;
xyz.getKeySet().contains("x");  //will return true;

class Point implements ToJSONable {
  public Point(boolean outputSpherical) {
    this.outputSpherical = outputSpherical;
    //other initialization...
  }
  
  public JSONObject asJSON() {
    JSONObject json = new StandardJSONObject();
    
    if(outputSpherical) {
      json.add("theta", calcTheta(x,y));
      json.add("phi", calcPhi(y,z));
      json.add("rho", calcRho(x,y,z));
    } else {
      json.add("x", x);
      json.add("y", y);
      json.add("z", z);
    }
    
    return json;
  }
  
  private boolean outputSpherical;
  private double x, y, z;
}
```
## Getting Fancy - Parse/Serialize JSON to java.util.Map

One nice feature of WildPi-JSON is that it can help parse and serialize implementations of Java's Map interface.

Normally, JSON could handle a `Map` by creating on object which is a set of key-value pairs. This is problematic if your keys are not strings or do not serialize into a single string in a simple manner. To over come this annoyance, WildPi-JSON includes `JSONMapHeler` which will transform implementations of `Map` into WildPi-JSON's `JSONArray`. To do so successfully, you will need to supply functions which know how to transform the `Map`'s keys and values in to one of `JSONValue`s that WildPi-JSON knows how to parse. This means that the keys and values of the `Map` don't have to implement any of the intefaces supplied by WildPi-JSON (although the helps if they do). An example of this is shown below:

```java
String mapKey = "myKey";
int value = 1;

Map<String, Integer> originalMap = new HashMap<>();
originalMap.put(mapKey, value);

JSONArray jsonArray = JSONMapHelper.<String, Integer>jsonifyMap(originalMap,
                                                                StandardJSONString::new,
                                                                StandardJSONLong::new);

Map<String, Integer> afterMap = JSONMapHelper.extractMap(jsonArray,
                                                         (json, key) -> json.getString(key).toString(),
                                                         (json, key) -> json.getLong(key).toInt());
```
