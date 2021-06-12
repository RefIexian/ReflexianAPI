Reflexian Public API (Java)
======


This is a Java implementation of the Reflexian API. For discussing the API, requesting help or suggestions you can use the
GitHub [Discussions](https://github.com/RefLexian/ReflexianAPI/discussions).

### Documentation

Reflexian Public API documentation is currently being worked on. For API support join [our discord](https://discord.gg/s8x53ZhsQx).

### GitHub Issues

Github issues should only be used to report bugs. Everything else should either be in Github discussions or in our [Discord Server](https://discord.gg/s8x53ZhsQx).

### Usage

Add this to your maven pom.xml, replacing ``VERSION`` with the JitPack version below.

[![](https://jitpack.io/v/RefLexian/ReflexianAPI.svg)](https://jitpack.io/#RefLexian/ReflexianAPI)

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
	
<dependencies>
    <dependency>
        <groupId>com.github.Reflexian</groupId>
	<artifactId>ReflexianAPI</artifactId>
	<version>VERSION</version>
    </dependency>
</dependencies>	

```

### Dependencies

The Reflexian Public API has the following dependencies:

* Google Gson library
* Apache HttpClient

### Query Limitations

The API server has a request limit of 120 queries per minute. Any abuse of the API or intentions to bypass this limit (
such as with multiple API keys) will lead to your API key being reset or banned.

If you require a higher limit than the above you can open a support ticket at the [Reflexian Discord](https://discord.gg/s8x53ZhsQx) and provide
your use case and why you require a higher limit.

Additionally, users with the API Pass have a request limit of 240 queries per minute. Reflexian API Pass can be purchased through our discord.

### Obtaining an API Key (WIP)

You can obtain an API key by joining ```mc.reflexian.com``` with a valid Minecraft account and running the /api command.
You will then be assigned a unique key that is to remain **private**.

### Contributing

When contributing changes to the Java API please provide as much detail on the changes and the reasons for them. We will
not accept changes that have no meaningful contribution to the project.
