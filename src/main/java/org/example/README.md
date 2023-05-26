the kafka ui/cli intall the binary for windows
set the environment variables

kafka-topics --create --topic testKaf --bootstrap-server localhost:9092

to see the list of topics

kafka-topics --list --bootstrap-server localhost:9092

to see the consumer

kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning

This is how to send data in String type to certain topic

kafka-console-producer --broker-list localhost:9092 --topic lifeforce-generatedocumentproposal-response-dev

This how to delete a topic in kafka

kafka-topics --bootstrap-server localhost:9092 --delete --topic lifeforce-spajkdatka-request-dev

see list consumer group
./kafka-consumer-groups.sh --bootstrap-server <bootstrap-server> --list
