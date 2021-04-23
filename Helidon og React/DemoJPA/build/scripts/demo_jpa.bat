@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  demo_jpa startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and DEMO_JPA_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\demo_jpa-1.0-SNAPSHOT.jar;%APP_HOME%\lib\helidon-integrations-cdi-hibernate-2.0.1.jar;%APP_HOME%\lib\jakarta.persistence-api-2.2.3.jar;%APP_HOME%\lib\helidon-microprofile-2.0.1.jar;%APP_HOME%\lib\javax.transaction-api-1.2.jar;%APP_HOME%\lib\helidon-integrations-cdi-datasource-hikaricp-2.0.1.jar;%APP_HOME%\lib\helidon-integrations-cdi-jta-weld-2.0.1.jar;%APP_HOME%\lib\helidon-integrations-cdi-jpa-2.0.1.jar;%APP_HOME%\lib\helidon-media-jackson-2.0.1.jar;%APP_HOME%\lib\jersey-media-json-jackson-2.31.jar;%APP_HOME%\lib\mssql-jdbc-9.2.0.jre11.jar;%APP_HOME%\lib\helidon-microprofile-core-2.0.1.jar;%APP_HOME%\lib\helidon-microprofile-metrics-2.0.1.jar;%APP_HOME%\lib\helidon-microprofile-fault-tolerance-2.0.1.jar;%APP_HOME%\lib\helidon-microprofile-jwt-auth-2.0.1.jar;%APP_HOME%\lib\helidon-microprofile-openapi-2.0.1.jar;%APP_HOME%\lib\helidon-microprofile-tracing-2.0.1.jar;%APP_HOME%\lib\helidon-microprofile-security-2.0.1.jar;%APP_HOME%\lib\helidon-microprofile-server-2.0.1.jar;%APP_HOME%\lib\helidon-microprofile-health-2.0.1.jar;%APP_HOME%\lib\helidon-health-checks-2.0.1.jar;%APP_HOME%\lib\helidon-health-2.0.1.jar;%APP_HOME%\lib\helidon-metrics-2.0.1.jar;%APP_HOME%\lib\helidon-openapi-2.0.1.jar;%APP_HOME%\lib\helidon-webserver-jersey-2.0.1.jar;%APP_HOME%\lib\helidon-webserver-cors-2.0.1.jar;%APP_HOME%\lib\helidon-bundles-security-2.0.1.jar;%APP_HOME%\lib\helidon-security-providers-oidc-2.0.1.jar;%APP_HOME%\lib\helidon-webserver-2.0.1.jar;%APP_HOME%\lib\helidon-security-integration-jersey-client-2.0.1.jar;%APP_HOME%\lib\helidon-security-integration-jersey-2.0.1.jar;%APP_HOME%\lib\helidon-tracing-jersey-2.0.1.jar;%APP_HOME%\lib\helidon-tracing-jersey-client-2.0.1.jar;%APP_HOME%\lib\helidon-security-providers-oidc-common-2.0.1.jar;%APP_HOME%\lib\helidon-webclient-jaxrs-2.0.1.jar;%APP_HOME%\lib\helidon-jersey-common-2.0.1.jar;%APP_HOME%\lib\helidon-jersey-server-2.0.1.jar;%APP_HOME%\lib\helidon-microprofile-rest-client-2.0.1.jar;%APP_HOME%\lib\helidon-jersey-client-2.0.1.jar;%APP_HOME%\lib\helidon-jersey-media-jsonp-2.0.1.jar;%APP_HOME%\lib\helidon-media-jsonp-2.0.1.jar;%APP_HOME%\lib\helidon-media-common-2.0.1.jar;%APP_HOME%\lib\helidon-microprofile-config-2.0.1.jar;%APP_HOME%\lib\helidon-microprofile-cdi-2.0.1.jar;%APP_HOME%\lib\helidon-config-mp-2.0.1.jar;%APP_HOME%\lib\helidon-config-yaml-2.0.1.jar;%APP_HOME%\lib\helidon-config-encryption-2.0.1.jar;%APP_HOME%\lib\helidon-config-object-mapping-2.0.1.jar;%APP_HOME%\lib\helidon-security-providers-jwt-2.0.1.jar;%APP_HOME%\lib\helidon-security-jwt-2.0.1.jar;%APP_HOME%\lib\helidon-security-providers-header-2.0.1.jar;%APP_HOME%\lib\helidon-security-providers-http-auth-2.0.1.jar;%APP_HOME%\lib\helidon-security-providers-http-sign-2.0.1.jar;%APP_HOME%\lib\helidon-security-abac-role-2.0.1.jar;%APP_HOME%\lib\helidon-security-providers-common-2.0.1.jar;%APP_HOME%\lib\helidon-security-integration-webserver-2.0.1.jar;%APP_HOME%\lib\helidon-security-integration-common-2.0.1.jar;%APP_HOME%\lib\helidon-security-annotations-2.0.1.jar;%APP_HOME%\lib\helidon-security-abac-time-2.0.1.jar;%APP_HOME%\lib\helidon-security-abac-scope-2.0.1.jar;%APP_HOME%\lib\helidon-security-abac-policy-2.0.1.jar;%APP_HOME%\lib\helidon-security-providers-abac-2.0.1.jar;%APP_HOME%\lib\helidon-security-2.0.1.jar;%APP_HOME%\lib\helidon-common-key-util-2.0.1.jar;%APP_HOME%\lib\helidon-common-configurable-2.0.1.jar;%APP_HOME%\lib\helidon-tracing-config-2.0.1.jar;%APP_HOME%\lib\helidon-tracing-tracer-resolver-2.0.1.jar;%APP_HOME%\lib\helidon-security-util-2.0.1.jar;%APP_HOME%\lib\helidon-tracing-2.0.1.jar;%APP_HOME%\lib\helidon-config-2.0.1.jar;%APP_HOME%\lib\weld-se-core-2.0.1.jar;%APP_HOME%\lib\helidon-health-common-2.0.1.jar;%APP_HOME%\lib\helidon-common-http-2.0.1.jar;%APP_HOME%\lib\helidon-common-reactive-2.0.1.jar;%APP_HOME%\lib\helidon-common-context-2.0.1.jar;%APP_HOME%\lib\helidon-common-mapper-2.0.1.jar;%APP_HOME%\lib\helidon-common-media-type-2.0.1.jar;%APP_HOME%\lib\helidon-common-service-loader-2.0.1.jar;%APP_HOME%\lib\helidon-common-2.0.1.jar;%APP_HOME%\lib\helidon-integrations-cdi-reference-counted-context-2.0.1.jar;%APP_HOME%\lib\helidon-integrations-cdi-delegates-2.0.1.jar;%APP_HOME%\lib\helidon-integrations-cdi-datasource-2.0.1.jar;%APP_HOME%\lib\helidon-integrations-cdi-jta-2.0.1.jar;%APP_HOME%\lib\jersey-server-2.31.jar;%APP_HOME%\lib\jersey-client-2.31.jar;%APP_HOME%\lib\jersey-hk2-2.31.jar;%APP_HOME%\lib\jersey-media-json-processing-2.31.jar;%APP_HOME%\lib\jersey-common-2.31.jar;%APP_HOME%\lib\jersey-entity-filtering-2.31.jar;%APP_HOME%\lib\jersey-weld2-se-2.31.jar;%APP_HOME%\lib\jersey-cdi1x-2.31.jar;%APP_HOME%\lib\jersey-mp-rest-client-2.31.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.10.0.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.10.0.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.10.0.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.10.1.jar;%APP_HOME%\lib\jackson-databind-2.10.1.jar;%APP_HOME%\lib\jackson-annotations-2.10.1.jar;%APP_HOME%\lib\jackson-core-2.10.1.jar;%APP_HOME%\lib\opentracing-util-0.33.0.jar;%APP_HOME%\lib\opentracing-tracerresolver-0.1.8.jar;%APP_HOME%\lib\opentracing-noop-0.33.0.jar;%APP_HOME%\lib\opentracing-api-0.33.0.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.3.jar;%APP_HOME%\lib\jakarta.ws.rs-api-2.1.6.jar;%APP_HOME%\lib\weld-jta-3.1.3.Final.jar;%APP_HOME%\lib\weld-spi-3.1.SP2.jar;%APP_HOME%\lib\weld-api-3.1.SP2.jar;%APP_HOME%\lib\weld-probe-core-3.1.3.Final.jar;%APP_HOME%\lib\jakarta.enterprise.cdi-api-2.0.2.jar;%APP_HOME%\lib\jakarta.el-api-3.0.3.jar;%APP_HOME%\lib\jakarta.interceptor-api-1.2.5.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.5.jar;%APP_HOME%\lib\jakarta.inject-api-1.0.jar;%APP_HOME%\lib\yasson-1.0.6.jar;%APP_HOME%\lib\jakarta.json.bind-api-1.0.2.jar;%APP_HOME%\lib\jakarta.activation-api-1.2.2.jar;%APP_HOME%\lib\jakarta.json-1.1.6-module.jar;%APP_HOME%\lib\jakarta.json-1.1.6.jar;%APP_HOME%\lib\netty-codec-http2-4.1.45.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.45.Final.jar;%APP_HOME%\lib\netty-handler-4.1.45.Final.jar;%APP_HOME%\lib\netty-codec-4.1.45.Final.jar;%APP_HOME%\lib\netty-transport-4.1.45.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.45.Final.jar;%APP_HOME%\lib\snakeyaml-1.24.jar;%APP_HOME%\lib\smallrye-open-api-1.2.0.jar;%APP_HOME%\lib\microprofile-config-api-1.4.jar;%APP_HOME%\lib\microprofile-health-api-2.1.jar;%APP_HOME%\lib\microprofile-jwt-auth-api-1.1.1.jar;%APP_HOME%\lib\microprofile-fault-tolerance-api-2.0.2.jar;%APP_HOME%\lib\microprofile-opentracing-api-1.3.1.jar;%APP_HOME%\lib\microprofile-rest-client-api-1.3.3.jar;%APP_HOME%\lib\microprofile-openapi-api-1.1.2.jar;%APP_HOME%\lib\microprofile-metrics-api-2.2.jar;%APP_HOME%\lib\hystrix-core-1.5.18.jar;%APP_HOME%\lib\failsafe-2.3.1.jar;%APP_HOME%\lib\hibernate-core-5.4.4.Final.jar;%APP_HOME%\lib\jandex-2.1.2.Final.jar;%APP_HOME%\lib\HikariCP-3.4.1.jar;%APP_HOME%\lib\archaius-core-0.4.1.jar;%APP_HOME%\lib\slf4j-jdk14-1.7.26.jar;%APP_HOME%\lib\slf4j-api-1.7.26.jar;%APP_HOME%\lib\jakarta.ejb-api-3.2.6.jar;%APP_HOME%\lib\jakarta.transaction-api-1.3.3.jar;%APP_HOME%\lib\jakarta.validation-api-2.0.2.jar;%APP_HOME%\lib\cdi-5.9.3.Final.jar;%APP_HOME%\lib\jboss-transaction-spi-7.6.0.Final.jar;%APP_HOME%\lib\jboss-transaction-api_1.2_spec-1.1.1.Final.jar;%APP_HOME%\lib\weld-environment-common-3.1.3.Final.jar;%APP_HOME%\lib\jboss-classfilewriter-1.2.4.Final.jar;%APP_HOME%\lib\commons-configuration-1.8.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\hibernate-commons-annotations-5.1.0.Final.jar;%APP_HOME%\lib\jboss-logging-3.4.1.Final.jar;%APP_HOME%\lib\javassist-3.25.0-GA.jar;%APP_HOME%\lib\byte-buddy-1.9.11.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\classmate-1.3.4.jar;%APP_HOME%\lib\dom4j-2.1.1.jar;%APP_HOME%\lib\jaxb-runtime-2.3.1.jar;%APP_HOME%\lib\jboss-transaction-api_1.3_spec-2.0.0.Final.jar;%APP_HOME%\lib\jta-5.9.3.Final.jar;%APP_HOME%\lib\jakarta.inject-2.6.1.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.3.jar;%APP_HOME%\lib\rxjava-1.2.0.jar;%APP_HOME%\lib\HdrHistogram-2.1.9.jar;%APP_HOME%\lib\txw2-2.3.1.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.7.jar;%APP_HOME%\lib\stax-ex-1.8.jar;%APP_HOME%\lib\FastInfoset-1.2.15.jar;%APP_HOME%\lib\arjuna-5.9.3.Final.jar;%APP_HOME%\lib\common-5.9.3.Final.jar;%APP_HOME%\lib\hk2-locator-2.6.1.jar;%APP_HOME%\lib\weld-core-impl-2.0.1.jar;%APP_HOME%\lib\netty-resolver-4.1.45.Final.jar;%APP_HOME%\lib\netty-common-4.1.45.Final.jar;%APP_HOME%\lib\jsonp-jaxrs-1.1.6.jar;%APP_HOME%\lib\commons-lang-2.6.jar;%APP_HOME%\lib\hk2-api-2.6.1.jar;%APP_HOME%\lib\aopalliance-repackaged-2.6.1.jar;%APP_HOME%\lib\hk2-utils-2.6.1.jar


@rem Execute demo_jpa
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %DEMO_JPA_OPTS%  -classpath "%CLASSPATH%" dk.howard.Main %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable DEMO_JPA_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%DEMO_JPA_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
