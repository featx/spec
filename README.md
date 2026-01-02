# spec - 通用基础依赖库

[![Build Status](https://github.com/featx/spec/workflows/Gradle/badge.svg)](https://github.com/featx/spec)
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](LICENSE)
[![Java Version](https://img.shields.io/badge/java-25+-orange.svg)](https://www.oracle.com/java/)
[![Kotlin Version](https://img.shields.io/badge/kotlin-2.3.0-blue.svg)](https://kotlinlang.org/)
[![Scala Version](https://img.shields.io/badge/scala-3.7.4-red.svg)](https://www.scala-lang.org/)
[![Groovy Version](https://img.shields.io/badge/groovy-5.0.3-green.svg)](https://groovy-lang.org/)

## 📖 项目简介

`spec` 是一个多语言通用基础依赖库，提供了一套完整的基础设施组件，支持 Java、Groovy、Scala 和 Kotlin 四种 JVM 语言。旨在为业务开发提供统一的抽象层和常用工具类。

## ✨ 核心特性

- 🚀 **多语言支持**: Java、Groovy、Scala、Kotlin
- 🏗️ **统一架构**: 提供一致的基础实体和接口抽象
- 🛠️ **工具类集合**: 涵盖常见开发场景的工具方法
- 🔧 **ID 生成**: 内置雪花算法等分布式ID生成方案
- 📊 **分页支持**: 完整的分页查询模型和工具
- 🔒 **错误处理**: 标准化的业务异常处理机制
- 🌐 **网络工具**: IP地址解析和网络相关工具
- 📝 **时间处理**: 日期时间操作的工具集合

## 🏗️ 项目架构

```
spec/
├── src/main/java/          # Java 核心模块
│   ├── constant/           # 常量定义
│   ├── enums/             # 枚举类型
│   ├── error/             # 错误处理
│   ├── model/             # 数据模型
│   └── util/              # 工具类
├── src/main/groovy/       # Groovy 实体模块
│   └── entity/            # 基础实体类
├── src/main/kotlin/       # Kotlin 特性模块
│   └── feature/           # 扩展功能
└── src/main/scala/        # Scala 模型模块
    └── model/             # Scala 数据模型
```

## 📚 功能模块

### 1. 基础实体层 (Entity Layer)

#### Groovy 实体模块
- `AbstractAudit` - 审计基础实体
- `AbstractIdentifiable` - 可识别基础实体
- `AbstractRecord` - 记录基础实体
- `AbstractStateful` - 状态基础实体
- `AbstractUnified` - 统一基础实体
- `AbstractUpdate` - 更新基础实体

#### 消息处理
- `MessageReceive` - 消息接收模型
- `MessageSend` - 消息发送模型
- `SendBack` - 回执模型
- `SendException` - 发送异常模型
- `SendResponse` - 发送响应模型

### 2. 常量与枚举

#### 常量定义
- `ErrorCode` - 错误码常量
- `Formatter` - 格式化常量
- `HeaderName` - HTTP头名称常量
- `Symbol` - 符号常量

#### 枚举类型
- `BaseEnum` - 基础枚举接口
- `BusinessError` - 业务错误枚举
- `QueryDirection` - 查询方向枚举

### 3. 错误处理机制

- `BaseExceptionHandler` - 基础异常处理器
- `BusinessException` - 业务异常类
- `ErrorCode` - 错误码定义

### 4. 数据模型 (Model Layer)

#### 响应模型
- `BaseResponse` - 基础响应模型
- `ListResponse` - 列表响应模型
- `PageResponse` - 分页响应模型
- `FlowResponse` - 流程响应模型
- `RollResponse` - 回滚响应模型

#### 请求模型
- `PageRequest` - 分页请求模型
- `CodePageRequest` - 编码分页请求
- `NamePageRequest` - 名称分页请求
- `FlowRequest` - 流程请求模型
- `RollRequest` - 回滚请求模型
- `UserRequest` - 用户请求模型

#### 业务模型
- `Audit` - 审计信息
- `BaseUnified` - 基础统一模型
- `Coded` - 编码接口
- `Comment` - 注释模型
- `Identifiable` - 可识别接口
- `Named` - 命名接口
- `Record` - 记录接口
- `Selectable` - 可选择接口
- `Selection` - 选择项
- `Sortable` - 可排序接口
- `Stateful` - 状态接口
- `Unified` - 统一接口
- `Update` - 更新接口

### 5. 工具类集合 (Util Layer)

#### 集合工具
- `CollectionUtil` - 集合操作工具
- `MapUtil` - Map操作工具

#### 字符串工具
- `StringUtil` - 字符串处理工具
- `RegExUtil` - 正则表达式工具

#### 时间工具
- `DateTimeUtil` - 日期时间处理工具

#### ID工具
- `IdUtil` - ID生成和解析工具

#### 网络工具
- `IpUtil` - IP地址处理工具

#### 其他工具
- `CommonUtil` - 通用工具
- `OptionalUtil` - Optional操作工具

### 6. Kotlin 特性功能

- `IdGenerate` - ID生成扩展
- `ModelConvert` - 模型转换扩展
- `ReflectionModelConverter` - 反射模型转换器
- `SnowflakeIdWorker` - 雪花算法ID生成器

## 🚀 快速开始

### 依赖引入

#### Maven
```xml
<dependency>
    <groupId>org.featx</groupId>
    <artifactId>spec</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### Gradle
```gradle
implementation 'org.featx:spec:1.0.0'
```

### 基本使用示例

#### 1. 基础响应模型
```java
// 创建成功响应
BaseResponse<String> response = BaseResponse.succeeded("操作成功");

// 创建失败响应
BaseResponse<Void> errorResponse = BaseResponse.occur(BusinessError.VALIDATION_ERROR);
```

#### 2. 分页查询
```java
// 创建分页请求
PageRequest pageRequest = PageRequest.builder()
    .pageNum(1)
    .pageSize(20)
    .build();

// 使用分页响应
PageResponse<User> pageResponse = PageResponse.of(users, total, pageRequest);
```

#### 3. 业务异常处理
```java
// 抛出业务异常
throw BusinessException.of(BusinessError.DATA_NOT_FOUND, "用户不存在");

// 使用错误码
throw BusinessException.of(ErrorCode.SERVER_ERROR, "服务器内部错误");
```

#### 4. 工具类使用
```java
// 集合工具
boolean isEmpty = CollectionUtil.isEmpty(list);

// 字符串工具
String trimmed = StringUtil.trimToNull("  test  ");

// ID生成
String id = IdUtil.generate();

// IP处理
String clientIp = IpUtil.getClientIp(request);
```

#### 5. Kotlin 扩展功能
```kotlin
// ID生成
val id = "test".generateId()

// 模型转换
val userDto = userModel.toDto()

// 雪花算法ID
val snowflakeId = SnowflakeIdWorker.nextId()
```

## 🛠️ 开发环境要求

- **JDK**: 25+
- **Gradle**: 9.2.1+
- **Kotlin**: 2.3.0
- **Scala**: 3.7.4
- **Groovy**: 5.0.3

## 📦 构建说明

```bash
# 克隆项目
git clone https://github.com/featx/spec.git

# 进入项目目录
cd spec

# 设置JAVA_HOME
$env:JAVA_HOME="C:\Users\nuc\.jdks\openjdk-25.0.1"

# 编译项目
./gradlew clean compileJava compileKotlin compileScala

# 运行测试
./gradlew test

# 构建发布包
./gradlew clean build

# 发布到Maven仓库
./gradlew publish
```

## 🎯 适用场景

- **微服务架构**: 提供统一的基础实体和接口抽象
- **多语言项目**: 支持在同一项目中使用多种JVM语言
- **RESTful API**: 标准化的请求/响应模型
- **分布式系统**: 内置ID生成和网络工具
- **企业级应用**: 完整的错误处理和审计机制

## 📋 设计原则

1. **统一性**: 跨语言的统一设计模式
2. **扩展性**: 易于扩展和定制
3. **兼容性**: 向后兼容和渐进式升级
4. **性能**: 高效的实现和优化的算法
5. **可维护性**: 清晰的代码结构和文档

## 🤝 贡献指南

1. Fork 本项目
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开 Pull Request

## 📄 许可证

本项目基于 Apache 2.0 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情。

## 📞 联系方式

- 项目链接: [https://github.com/featx/spec](https://github.com/featx/spec)
- 问题反馈: [Issues](https://github.com/featx/spec/issues)

---

⭐ 如果这个项目对你有帮助，请给它一个星标！