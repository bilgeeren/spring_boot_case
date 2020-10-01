# spring_boot_case

This is a simle courier tracking application written with Java - SpringBoot 

To run this application:

1) Go under the courier_track_app directory 
2) Run run.sh script

      use ``` sh run.sh -m ``` to run with Maven

      use ``` sh run.sh -j ``` to run with Java Jar

This RestAPI runs at LocalHost::8080 port.

END POINTS: 

GET: 

- ``` /courier ``` -> Returns Courıer List
- ``` /courier/?id={id} ``` -> Returns Courier with given id
- ``` /courier/totalDistance/?id={id} ``` -> Returns Total travel distance of Courier with given id ( Distance unit: METER )
- ``` /store ```-> Returns Store list
- ``` /store/?id={id} ``` -> Returns Store with given id
- ``` /courierLogs ```-> Returns CourierLog List
- ``` /courierLogs/?id={id} ``` -> Returns Courier Logs with given courierId
- ``` /lastNearLogs ``` -> Returns CourierId - StoreId - time object (When any courier lastly in 100 m range of the any store)

POST:

- ```/courier``` -> Request body as JSON with courier class keys. -> Saves courier (Not necessary if log saved courier automaticly saved or updated)
- ```/store``` -> Request body as JSON with store class keys. -> Saves store (Not necessary Stores saved at initialization from stores.json)
- ```/courierLogs/addLog``` -> Request body as JSON with courierLog class keys. -> Saves log entry. 
            
            CourierLog Body: {"courierId":"1", "lat": 41.0066851, "lng": 28.6555562, "logTime": "06:52:24"}

