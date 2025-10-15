<h1 align="center">
Проект по автоматизации тестовых сценариев для Regard.ru
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
  <a href="https://www.jetbrains.com/idea/"><img width="6%" src="media/logos/IntelliJ_IDEA.png" alt="IntelliJ IDEA logo" title="IntelliJ IDEA"/></a>
  <a href="https://gradle.org/"><img width="6%" src="media/logos/Gradle.png" alt="Gradle logo" title="Gradle"/></a>
  <a href="https://www.java.com/"><img width="6%" src="media/logos/Java.png" alt="Java logo" title="Java"/></a>
  <a href="https://selenide.org/"><img width="6%" src="media/logos/Selenide.png" alt="Selenide logo" title="Selenide"/></a>
  <a href="https://junit.org/"><img width="6%" src="media/logos/JUnit5.png" alt="JUnit5 logo" title="JUnit5"/></a>
  <a href="https://github.com/"><img width="6%" src="media/logos/GitHub.png" alt="GitHub logo" title="GitHub"/></a>
  <a href="https://aerokube.com/selenoid/latest/"><img width="6%" src="media/logos/Selenoid.png" alt="Selenoid logo" title="Selenoid"/></a>
  <a href="https://qameta.io/"><img width="6%" src="media/logos/Allure_Report.png" alt="Allure Report logo" title="Allure Report"/></a>
  <a href="https://www.jenkins.io/"><img width="6%" src="media/logos/Jenkins.png" alt="Jenkins logo" title="Jenkins"/></a>
  <a href="https://telegram.org/"><img width="6%" src="media/logos/Telegram.png" alt="Telegram logo" title="Telegram"/></a>
  <a href="https://qameta.io/"><img width="6%" src="media/logos/Allure_TestOps.png" alt="Allure TestOps logo" title="Allure TestOps"/></a>
  <a href="https://www.atlassian.com/software/jira"><img width="6%" src="media/logos/Atlassian_Jira.png" alt="Atlassian Jira logo" title="Atlassian Jira"/></a>
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования <code>Selenide</code>.
- В качестве сборщика был использован - <code>Gradle</code>.  
- Использованы фреймворки <code>JUnit 5</code> и <code>Selenide</code>.
- При прогоне тестов браузер запускается в <code>Selenoid</code>.
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием <code>Allure Report</code> и отправкой результатов в <code>Telegram</code> при помощи бота. 
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>

Содержание Allure-отчета:
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

## <img width="4%" src="media/logos/Jenkins.png" alt="Jenkins logo" title="Jenkins"/> Сборка в Jenkins
<p align="center">
<img src="media/screenshots/Jenkins_job.png" alt="Jenkins Job screenshot" title="Jenkins Job"/>
</p>

## <img width="4%" src="media/logos/Allure_Report.png" alt="Allure Report logo" title="Allure Report"/> Пример Allure отчёта

### Overview

<p align="center">
<img src="media/screenshots/Allure_Report_1.png" alt="Allure Report screenshot" title="Allure Report"/>
</p>

### Результат выполнения теста

<p align="center">
<img src="media/screenshots/Allure_Report_2.png" alt="Allure test results screenshot" title="Allure test results"/>
</p>

## <img width="4%" src="media/logos/Allure_TestOps.png" alt="Allure TestOps logo" title="Allure TestOps"/> Интеграция с Allure TestOps

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>.
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

<p align="center">
<img src="media/screenshots/Allure_Testops_run.png" alt="Allure TestOps screenshot" title="Allure TestOps"/>
</p>

## <img width="4%" src="media/logos/Atlassian_Jira.png" alt="Atlassian Jira logo" title="Atlassian Jira"/> Интеграция с Jira

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>.

<p align="center">
<img src="media/screenshots/Jira_task.png" alt="Jira screenshot" title="Jira"/>
</p>

## <img width="4%" src="media/logos/Telegram.png" alt="Telegram logo" title="Telegram"/> Уведомления в Telegram с использованием бота

После завершения сборки бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img src="media/screenshots/Telegram_notification.png" alt="Telegram notification screenshot" title="Telegram notification"/>
</p>

## <img width="4%" src="media/logos/Selenoid.png" alt="Selenoid logo" title="Selenoid"/> Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.

<p align="center">
<img src="media/screenshots/Selenoid_recording.gif" alt="Selenoid recording gif" title="Selenoid recording"/>
</p>
