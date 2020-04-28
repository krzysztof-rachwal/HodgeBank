#!/bin/bash
su centos #this will not work - as demonstrated below.
cd /home/centos
whoami
echo logged in as $USER.
echo in directory $PWD

echo "installing MariaDB..."
sudo yum install mysql -y
sudo yum install mariadb-server -y
sudo systemctl start mariadb
sudo systemctl status mariadb
sudo systemctl enable mariadb

sudo yum install git -y
sudo yum install wget -y
sudo yum install unzip -y

#curl -O https://download.java.net/java/GA/jdk10/10.0.2/19aef61b38124481863b1413dce1855f/13/openjdk-10.0.2_linux-x64_bin.tar.gz
#tar zxvf openjdk-10.0.2_linux-x64_bin.tar.gz
#sudo mv jdk-10.0.2 /usr/local/
#export JAVA_HOME=/usr/local/jdk-10.0.2
#export PATH=:$JAVA_HOME/bin

#wget https://services.gradle.org/distributions/gradle-4.7-bin.zip

#sudo mkdir /opt/gradle
#sudo unzip -d /opt/gradle gradle-4.7-bin.zip
#export PATH=$PATH:/opt/gradle/gradle-4.7/bin

sudo touch ~/.ssh/known_hosts
sudo ssh-keyscan gitlab.cs.cf.ac.uk >> ~/.ssh/known_hosts 
sudo chmod 644 ~/.ssh/known_hosts

touch gitlab_takeaway_keypair.key
cat << `EOF` >> gitlab_takeaway_keypair.key
-----BEGIN RSA PRIVATE KEY-----
MIIEpAIBAAKCAQEAo5DsPGgjiKPTZd+/EUkITCrkiW9ybztonyqfvPXTfykFQvWI
Mm2WV1z8L1JW8BLJpo6YdhAgAbku/rtUSgffd1N9jpTOvmBKwwMtENAFV1xIE0ok
XvzcvC7Fp8WV/yRrlWTsMVFvjnbKEirflA+2gEUePjAfsVmW8VmYKi6pb8T6xe/H
wJy23Jk89k3wcAEwidp2vQHdWIbSObCvm2uFXnlDMFet7hxl8wNgE/7gdyhV0jJe
Uk2usK295zatiNXcu8uvfMl8xgJtyKgCIiMYqG7eIWdhX6vIBxTgJPmdBzVBddMU
+y7zCYdAlvvDDf+Ph+b7aHCpdNoWuTfd5lYebQIDAQABAoIBAHDDD2nRrXWc47de
2j1TaQoBpA5vq6etgEICw58kpksK/5qa5OtHC5ds/lqtXEwj16sgsVDravVlMlXg
1Yo4BUIhZ/Ts997dSY1J2j61+oiwkOvjeFGX56FAaXlxSShddmHG8uJJLyw7DrIZ
potPjdS+UcwzpxXAGsSGrNWf16W6PzhlERjWcfrWro6CA0yIZ23XnKwMnudzK79a
czyO8Lib7xcX/0S/Wh2HqV+BjPry/0hgyN0KwaX6l87Lde6k3vww/HoFPoXVUeMY
7DvCeLlAuuEi86gOJvBAGaZXEf3K0P9nnKs4F4WJ0yuHEWV4DAhkggpzUsneteOy
rukLj0ECgYEA2R19A9Qcvh0Ry4xY/3jPvpztVlaGOScwbWCoeYwx02NQxLMwS6D4
iaVm9vBYH83/0P0Rl2mHxPGjOmdc4Ei+/g/9gWxYRNZYmQW5RntN9eg6m9rGDEX5
oeaBDSRMUfl7z3TGz5TPP9F7DZODr5BCKGL8iNo+R4fCY5REFJggxvECgYEAwNxD
XZms6owcdBk6if+Hl7SlCh+GVtgrbrWhEV2jM7tMK2ge7CXKinxBbM9YjsMkpFbu
q5mDH3N3HH+2mY7VDID7LpXhZgSj45H9aAWZiARRxGYLRFh+jbCe60Se5j+zUkuc
Pwmu+GMYwcqkdBVyd0Xpf7CQt063dPCJolu4Jz0CgYEAkq/fpNSMTs3pFfLOtlvz
T79KgsiWisq1Z1Ckwuo7R6yUBzFhcddh0+2SMUiU4XgWXCZ+2iOMfT0coPrwvv+n
OpOnHOgMgwWmekxprvrj4z5xSpd2sxgb3oyTqENb5Q5/3dvx7pGFrIJldvixQc5f
RFYMdJGu/jj01r53eMqHaqECgYAv4P7gZ9xjxjDyKak8xTFWWkR2xOjG+pedvn2k
IAj6OM9qH0k9+wvTYZGkf71Og+e+3M4Xz96bmkDB1HrymGEP3518LT1t5E0DnCS7
BFjfSaM7DNJTP1z7tBNf+QMxyjKshZTemXrUs1VcFwDIyOJH9hVH2/+xYlttLqIc
qoSHSQKBgQDMII3EFgZ69nn28YRdVGs+SY4fwfCIyu3YbXlcPI6/qSiGBZDfdwze
NINT209SIKEDhye2wqtmt4b7zspRZpu64atCDm0121uxdxQbFxLXO/h+YZfJ2AZt
rMnFpXgp1FAu9MlGbCgVbOX4tH2/diGiiUSD/XTVXHg1nomc4ilfdQ==
-----END RSA PRIVATE KEY-----
`EOF`

chmod 400 gitlab_takeaway_keypair.key
ssh-agent bash -c 'ssh-add gitlab_takeaway_keypair.key'
ssh-agent bash -c 'ssh-add gitlab_takeaway_keypair.key; git clone -b KrisLivesHere git@gitlab.cs.cf.ac.uk:c1987417/hodgebank.git'

cd hodgebank
mysql -u root < "database.sql"
#mysql -p -u root c1973857_Team5 -e" SELECT * FROM users;"

mysql -u root -e "USE mysql; UPDATE user SET password=PASSWORD('comsc') WHERE User='root' AND Host='localhost'; FLUSH PRIVILEGES;"

#echo "Installing Java..."
#sudo yum -y install java-1.8.0-openjdk wget unzip
#wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/10.0.2+13/19aef61b38124481863b1413dce1855f/jdk-10.0.2_linux-x64_bin.rpm
#wget --no-cookies --no-check-certificate --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/11+28/55eed80b163941c8885ad9298e6d786a/jdk-11_linux-x64_bin.tar.gz
#sudo yum localinstall jdk-*_linux-x64_bin.rpm -y

curl -O https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_linux-x64_bin.tar.gz
#curl -O https://download.java.net/java/GA/jdk10/10.0.2/19aef61b38124481863b1413dce1855f/13/openjdk-10.0.2_linux-x64_bin.tar.gz
tar zxvf openjdk-11.0.1_linux-x64_bin.tar.gz
sudo mv jdk-11.0.1 /usr/local/
export JAVA_HOME=/usr/local/jdk-11.0.1
export PATH=$PATH:$JAVA_HOME/bin
java -version


echo "Installing gradle..."
wget https://services.gradle.org/distributions/gradle-5.6.4-bin.zip
sudo mkdir /opt/gradle
sudo unzip -d /opt/gradle gradle-5.6.4-bin.zip
export PATH=$PATH:/opt/gradle/gradle-5.6.4/bin
#gradle -v

gradle build
gradle bootrun