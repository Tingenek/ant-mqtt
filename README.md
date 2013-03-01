ant-mqtt
========

Small library to connect to a  
[MQTT](http://mqtt.org) broker.
Publish only, Qos 0, retained, timeout 30s
See [Blog] (http://tingenek.wordpress.com/2009/10/14/mqtt-ant-task/)

Dependencies:
ant.jar (1.8.4)
wmqtt.jar (from IA92)

Usage:
```
<target name="demo">
      <mqttant name="Bob" 
      url="tcp://localhost:1883" 
      topic="mqttant"
      payload="Hello from Ant"/>
</target>
```
