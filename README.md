# Overview

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/awt-extensions/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/awt-extensions/actions/workflows/gradle.yml)
[![Coverage Status](https://codecov.io/gh/astrapi69/awt-extensions/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/awt-extensions)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/awt-extensions.svg?style=flat)](https://github.com/astrapi69/awt-extensions/issues)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.astrapi69/awt-extensions)](https://central.sonatype.com/artifact/io.github.astrapi69/awt-extensions)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/awt-extensions.svg)](http://www.javadoc.io/doc/io.github.astrapi69/awt-extensions)
[![MIT License](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/awt-extensions?branch=develop)](https://hitsofcode.com/github/astrapi69/awt-extensions/view?branch=develop)

</div>

Tiny library for hold utility classes for java awt.

> Please support this project by simply putting a Github <a class="github-button" href="https://github.com/astrapi69/awt-extensions" data-icon="octicon-star" aria-label="Star astrapi69/awt-extensions on GitHub">
> Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this project
> [![Donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

# Template from this project

You can derive your java library project from this you can easily and adapt to your specific project if you follow the
instruction from this [medium blog](https://asterios-raptis.medium.com/new-github-template-repository-feature-ec09afe261b8)

## Note

No animals were harmed in the making of this library.

## License

The source code comes under the liberal MIT License, making awt-extensions great for all types of applications.

## gradle dependency

Replace the variable ${latestVersion} with the current latest version: [![Maven Central](https://img.shields.io/maven-central/v/io.github.astrapi69/awt-extensions)](https://central.sonatype.com/artifact/io.github.astrapi69/awt-extensions)

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of awt-extensions:

define version in file gradle.properties

```
awtExtensionsVersion=${latestVersion}
```

or in build.gradle ext area

```
    awtExtensionsVersion = "${latestVersion}"
```

then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:awt-extensions:$awtExtensionsVersion")
```

## Maven dependency

The library is on Maven Central. Check out [Maven Central](https://central.sonatype.com/artifact/io.github.astrapi69/awt-extensions) for the latest release.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of awt-extensions:

Then you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- awt-extensions version -->
        <awt-extensions.version>${latestVersion}</awt-extensions.version>
            ...
    </properties>
            ...
        <dependencies>
            ...
            <!-- awt-extensions DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>awt-extensions</artifactId>
                <version>${awt-extensions.version}</version>
            </dependency>
            ...
        </dependencies>

## Support this project

If awt-extensions is useful to you, a star on [GitHub](https://github.com/astrapi69/awt-extensions) helps others find it.
Sharing it or reporting a bug helps just as much.

If you would like to contribute financially, the channels are on the repository's Sponsor button, which
reads [.github/FUNDING.yml](.github/FUNDING.yml): GitHub Sponsors, Liberapay, Ko-fi and PayPal.

## Semantic Versioning

The versions of awt-extensions are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## What can i do to support this project

You can donate or contribute solve issues or pull request. Every support are welcome.

## Want to Help and improve it? ###

The source code for awt-extensions are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/awt-extensions/fork](https://github.com/astrapi69/awt-extensions/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/awt-extensions/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the awt-extensions developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/astrapi69/awt-extensions/issues).

## Similar projects

## Credits
