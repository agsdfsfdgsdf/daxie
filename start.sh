#! /bin/bash
#! /bin/sh
. /etc/profile
. ~/.bash_profile


if [ ! -d "logs" ];then
  mkdir logs
fi

  JAR_NAME=daxieCloudService-1.0.jar
  JAR_ProcNumber=`ps -ef |grep -w $JAR_NAME|grep -v grep|wc -l`
if [ $JAR_ProcNumber -le 0 ];then
		
	nohup	 java -Xms8192m -Xmx8192m -jar $JAR_NAME  --spring.config.location=application.yml >/dev/null 2>&1 &
else
   PID=`ps -ef | grep "$JAR_NAME" | grep -v "grep" | awk '{print $2}'`
   echo  "$PID"
   echo "$JAR_NAME is  running..$JAR_ProcNumber"
	kill -9 $PID
   echo "kill $JAR_NAME success"
    nohup  java -Xms8192m -Xmx8192m -jar $JAR_NAME --spring.config.location=application.yml >/dev/null 2>&1 &
   echo "restart $JAR_NAME now "
fi

