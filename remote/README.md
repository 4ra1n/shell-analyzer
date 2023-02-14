## 远程连接 

(1) 查询 PID

./jdk1.8.0_202/bin/jps

(2) 远程Attach Agent

./jdk1.8.0_202/bin/java -cp ./jdk1.8.0_202/lib/tools.jar:remote-1.0-SNAPSHOT.jar com.n1ar4.RemoteLoader ${PID}

(3) 使用本工具连接