<h1 align="center">
Проект по автоматизации тестовых сценариев<br>для магазина <a href="https://www.regard.ru/" target="_blank" rel="noopener noreferrer">Регард</a>
<br><br>
<a href="https://www.regard.ru/" target="_blank" rel="noopener noreferrer"><img width="80%" src="media/logos/regard.png" alt="Regard logo" title="Regard"/></a>
</h1>

## 📌 Содержание:

- [Использованный стек технологий](#использованный-стек-технологий)
- [Запуск тестов из терминала](#запуск-автотестов)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Пример Allure-отчёта](#пример-allure-отчёта)
- [Уведомления в Telegram с использованием бота](#уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## 💻 Использованный стек технологий

<p align="center">
  <a href="https://www.jetbrains.com/idea/" target="_blank" rel="noopener noreferrer"><img width="6%" src="media/logos/intellij_idea.png" alt="IntelliJ IDEA logo" title="IntelliJ IDEA"/></a>
  <a href="https://gradle.org/" target="_blank" rel="noopener noreferrer"><img width="6%" src="media/logos/gradle.png" alt="Gradle logo" title="Gradle"/></a>
  <a href="https://www.java.com/" target="_blank" rel="noopener noreferrer"><img width="6%" src="media/logos/java.png" alt="Java logo" title="Java"/></a>
  <a href="https://selenide.org/" target="_blank" rel="noopener noreferrer"><img width="6%" src="media/logos/selenide.png" alt="Selenide logo" title="Selenide"/></a>
  <a href="https://junit.org/" target="_blank" rel="noopener noreferrer"><img width="6%" src="media/logos/junit5.png" alt="JUnit5 logo" title="JUnit5"/></a>
  <a href="https://github.com/" target="_blank" rel="noopener noreferrer"><img width="6%" src="media/logos/github.png" alt="GitHub logo" title="GitHub"/></a>
  <a href="https://aerokube.com/selenoid/latest/" target="_blank" rel="noopener noreferrer"><img width="6%" src="media/logos/selenoid.png" alt="Selenoid logo" title="Selenoid"/></a>
  <a href="https://qameta.io/" target="_blank" rel="noopener noreferrer"><img width="6%" src="media/logos/allure_report.png" alt="Allure Report logo" title="Allure Report"/></a>
  <a href="https://www.jenkins.io/" target="_blank" rel="noopener noreferrer"><img width="6%" src="media/logos/jenkins.png" alt="Jenkins logo" title="Jenkins"/></a>
  <a href="https://telegram.org/" target="_blank" rel="noopener noreferrer"><img width="6%" src="media/logos/telegram.png" alt="Telegram logo" title="Telegram"/></a>
  <a href="https://qameta.io/" target="_blank" rel="noopener noreferrer"><img width="6%" src="media/logos/allure_testops.png" alt="Allure TestOps logo" title="Allure TestOps"/></a>
  <a href="https://www.atlassian.com/software/jira" target="_blank" rel="noopener noreferrer"><img width="6%" src="media/logos/atlassian_jira.png" alt="Atlassian Jira logo" title="Atlassian Jira"/></a>
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования <code>Selenide</code>.
- В качестве сборщика был использован - <code>Gradle</code>.  
- Использованы фреймворки <code>JUnit 5</code> и <code>Selenide</code>.
- При прогоне тестов браузер запускается в <code>Selenoid</code>.
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием <code>Allure Report</code> и отправкой результатов в <code>Telegram</code> при помощи бота. 
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>

Содержание Allure-отчёта:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## ▶️ Запуск автотестов

### Запуск тестов из терминала

При выполнении команды данные тесты запустятся локально.

```
gradle clean test
```

### Запуск тестов на удаленном браузере

При выполнении команд данные тесты запустятся удаленно в <code>Selenoid</code>.

```
gradle clean test
-DremoteUrl=${SELENOID_URL}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
allureReport
```

### Параметры сборки

* <code>SELENOID_URL</code> - ссылка на Selenoid. По умолчанию: <code>selenoid.autotests.cloud</code>.
* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По-умолчанию: <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По-умолчанию - <code>128.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По умолчанию: 1920x1080.

## <img width="4%" src="media/logos/jenkins.png" alt="Jenkins logo" title="Jenkins"/> Сборка в Jenkins
<p align="center">
<img width="100%" src="media/screenshots/jenkins_job.png" alt="Jenkins Job screenshot" title="Jenkins Job"/>
</p>

## <img width="4%" src="media/logos/allure_report.png" alt="Allure Report logo" title="Allure Report"/> Пример Allure отчёта

### Overview

<p align="center">
<img width="100%" src="media/screenshots/allure_report_1.png" alt="Allure Report screenshot" title="Allure Report"/>
</p>

### Результат выполнения теста

<p align="center">
<img width="100%" src="media/screenshots/allure_report_2.png" alt="Allure test results screenshot" title="Allure test results"/>
</p>

## <img width="4%" src="media/logos/allure_testops.png" alt="Allure TestOps logo" title="Allure TestOps"/> Интеграция с Allure TestOps

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>.
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

<p align="center">
<img width="100%" src="media/screenshots/allure_testops_run.png" alt="Allure TestOps screenshot" title="Allure TestOps"/>
</p>

## <img width="4%" src="media/logos/atlassian_jira.png" alt="Atlassian Jira logo" title="Atlassian Jira"/> Интеграция с Jira

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>.

<p align="center">
<img width="100%" src="media/screenshots/jira_task.png" alt="Jira screenshot" title="Jira"/>
</p>

## <img width="4%" src="media/logos/telegram.png" alt="Telegram logo" title="Telegram"/> Уведомления в Telegram с использованием бота

После завершения сборки бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="100%" src="media/screenshots/telegram_notification.png" alt="Telegram notification screenshot" title="Telegram notification"/>
</p>

## <img width="4%" src="media/logos/selenoid.png" alt="Selenoid logo" title="Selenoid"/> Видео примера запуска тестов в Selenoid

К каждому тесту в отчёте прилагается видео прогона.

<p align="center">
<img width="100%" src="media/screenshots/selenoid_recording.gif" alt="Selenoid recording gif" title="Selenoid recording"/>
</p>
