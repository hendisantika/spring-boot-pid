# spring-boot-pid

An example project for PID generation with spring-boot.

The PID. This useful little thing. They are needed, for example, for init scripts or for monitoring the application. But how do I find the PID of a process? Sure ... just like that:

```jshelllanguage
fooHendis-MacBook-Pro:~ hendisantika$ pgrep java
25388
26084
Hendis-MacBook-Pro:~ hendisantika$ 
```

Hmm .... Helps only partially good. Let's try it differently:

```jshelllanguage
Hendis-MacBook-Pro:~ hendisantika$ jps -v
26113 Jps -Dapplication.home=/Library/Java/JavaVirtualMachines/openjdk-11.0.2.jdk/Contents/Home -Xms8m -Djdk.module.main=jdk.jcmd
26084 Launcher -Dclassworlds.conf=/usr/local/Cellar/maven/3.6.0/libexec/bin/m2.conf -Dmaven.home=/usr/local/Cellar/maven/3.6.0/libexec -Dlibrary.jansi.path=/usr/local/Cellar/maven/3.6.0/libexec/lib/jansi-native -Dmaven.multiModuleProjectDirectory=/Users/hendisantika/IdeaProjects/spring-boot-pid
25322  -Xms128m -Xmx4096m -XX:ReservedCodeCacheSize=240m -XX:+UseCompressedOops -Dfile.encoding=UTF-8 -XX:+UseConcMarkSweepGC -XX:SoftRefLRUPolicyMSPerMB=50 -ea -Dsun.io.useCanonCaches=false -Djava.net.preferIPv4Stack=true -Djdk.http.auth.tunneling.disabledSchemes="" -XX:+HeapDumpOnOutOfMemoryError -XX:-OmitStackTraceInFastThrow -Xverify:none -XX:ErrorFile=/Users/hendisantika/java_error_in_idea_%p.log -XX:HeapDumpPath=/Users/hendisantika/java_error_in_idea.hprof -Djb.vmOptionsFile=/Users/hendisantika/Library/Preferences/IntelliJIdea2018.3/idea.vmoptions -Didea.java.redist=jdk-bundled -Didea.home.path=/Applications/IntelliJ IDEA.app/Contents -Didea.executable=idea -Didea.paths.selector=IntelliJIdea2018.3
25388 RemoteMavenServer -Djava.awt.headless=true -Didea.version==2018.3.4 -Xmx768m -Didea.maven.embedder.version=3.3.9 -Dfile.encoding=UTF-8
Hendis-MacBook-Pro:~ hendisantika$ 

```

OK. Here we see the jar. Now we can easily get to the PID:

```jshelllanguage
Hendis-MacBook-Pro:~ hendisantika$ jps -v | grep spring-boot-pid | awk  '{print $1}'
26084
Hendis-MacBook-Pro:~ hendisantika$ 

```

yay! And here we go to our SysOps and can say, "We now know how you get to the PID from our process, which we would like to have in monitoring. You enter jps -v pipe grep... no. That's the way it works, but it's not going to make you happy. ;)