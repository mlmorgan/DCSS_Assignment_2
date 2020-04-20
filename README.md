# Air Monitoring System
To run this system:
1. Add all Jacorb libraries to the project module dependencies.
2. Precompile the IDL.
3. Start the Jacorb naming service.
4. Add the following program argument to all run configurations: `-ORBInitRef.NameService=file:<path to file to contain IOR of the name service>`.
5. Run the Monitoring Centre.
6. Add a program argument to the regional centre specifying its location, for example: `huddersfield`, or `manchester`.
7. Start the regional centre and modify the program arguments for any subsequent centres.
8. Add 2 program arguments to the monitoring station specifying its location and name, for example: `huddersfield one` or `manchester two`. The location argument must match the regional centre it is to be associated with, and the name must be unique within that region.
9. Start the monitoring station and modify the program arguments for any subsequent stations.
