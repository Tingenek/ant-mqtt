package org.btiowl.ant.taskdefs;

import org.apache.tools.ant.Task;
import org.apache.tools.ant.Project;
import com.ibm.mqtt.MqttClient;
import com.ibm.mqtt.MqttException;

public class MQTTAnt extends Task {
   private final static boolean CLEAN_START = true;
   private final static boolean RETAINED = true;
   private final static short KEEP_ALIVE = 30;
   private final static short QOS = 0;

   private String name="mqttant";
   private String url="tcp://localhost:1883";
   private String topic="mqttant";
   private String payload="hello from ant";
   private MqttClient client=null;

   public void setPayload(String payload) {
      this.payload = payload;
   }

   public String getPayload() {
      return payload;
   }

  public void setName(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

  public void setUrl(String url) {
      this.url = url;
   }

   public String getUrl() {
      return url;
   }

  public void setTopic(String topic) {
      this.topic = topic;
   }

   public String getTopic() {
      return topic;
   }

   public void execute() {
		try{
		client = new MqttClient(url);
		client.connect(name, CLEAN_START, KEEP_ALIVE );
		client.publish(topic,payload.getBytes(),QOS,RETAINED);
		log("Message published to mqtt", Project.MSG_INFO);
           }
        catch( MqttException exception )
           {
          log("MQTT error: " +exception.getCause(),Project.MSG_WARN);
           }
        finally {
           try {
               	if (client != null) {
               	client.disconnect();
        		}
           }
        catch (MqttException exception) {
          log("MQTT error: " +exception.getCause(),Project.MSG_WARN);
           }
       }
   }
}
