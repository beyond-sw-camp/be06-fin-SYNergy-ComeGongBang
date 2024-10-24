<h1 align="center">CI/CD</h1>

## ⛓️ Stacks

<br>

<div >
<img src="https://img.shields.io/badge/kubernates-326CE5?style=for-the-badge&logo=Kubernates&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/discord-326CE5?style=for-the-badge&logo=discord&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white" style="border-radius: 5px;">

[//]: # (<img src="https://img.shields.io/badge/VCALENDAR-4FC08D?style=for-the-badge&logo=Vue.js&logoColor=white"/>)

</div>

<br>

---


## ✏  CI/CD

## ☑️ 무중단 배포 - Blue/Green
#### 서비스의 안정성 확보
사용자들이 쿠폰을 발급받고, 결제를 진행하는 등의 중요한 시스템에서, 장애나 오류는 고객 경험에 치명적일 수 있다.<br/> 
블루/그린 배포 방식은 새로운 버전이 출시될 때, 모든 트래픽이 ***안전하게 새로운 버전(그린)*** 으로 전환될 때 까지 기존 버전을 그대로 유지하므로써 서비스 중단 없이 배포가 가능하다.<br/> 
만약 오류가 발생할 경우, ***즉시 블루 버전으로 롤백*** 이 가능하여 ***서비스의 안정성과 가용성을 극대화*** 할 수 있다.

#### 데이터와 사용자 경험의 일관성 보장
데이터베이스나 API 변경이 필요한 경우, 새로운 애플리케이션 시스템에서 상품의 재고, 주문 처리, 결제 내역 등의 중요한 데이터가 유실되거나 불일치하는 상황을 방지해야한다.<br/>
예를들어, 쇼핑몰의 쿠폰 발행, 결제 시스템과 같은 중요한 기능이 업데이트될 때, 업데이트된 기능이 일부 사용자에게만 제공되면 형평성에 어긋나거나 사용자에게 혼란을 초래할 수 있다.<br>
블루/그린 배포를 통해 한 번에 모든 사용자에게 새 기능을 제공하여, ***사용자 간의 경험 차이를 없애고 동일한 방식으로 기능을 이용*** 할 수 있도록 하였다.<br/><br/>

➡️ 따라서, 즉각적인 롤백을 통한 서비스 안정성 확보, 데이터와 사용자의 일관성 유지를 위해 Blue/Green 배포 방식을 채택하였다.

---
<br/>

## ☑️ 배포 자동화 - Jenkins
Jenkins를 통해 ***새로운 버전을 자동으로 배포하고 관리*** 하도록 하였다.<br/> 
이를 통해 수동 배포 과정에서 발생할 수 있는 사람의 실수를 줄일 수 있으며, 각 배포 시 발생하는 오류나 로그를 자동으로 수집하여 개발자가 빠르게 문제를 식별하고 대응할 수 있다.<br/> 
또한 시스템 가용성이 향상되고, 배포 작업에 필요한 시간과 리소스를 줄일 수 있다.
<br/><br/>

#### [backend pipeline]
![백엔드파이프라인2](https://github.com/user-attachments/assets/9e2c9d06-d135-4bab-b06a-35eeb6313ab8)
#### [frontend pipeline]
![프론트엔드 파이프라인](https://github.com/user-attachments/assets/9da0da0f-cf1d-43b8-bec9-7e35b9b7b6ca)

<h4>
더 자세한 설명은 아래를 클릭 :    <br>
    <br>
<a href="https://github.com/beyond-sw-camp/be06-fin-SYNergy-ComeGongBang/wiki/%F0%9F%93%8C-CI-CD"> 📤 CI/CD </a>
</h4>

<br>

<br>


<!--
## 💽&nbsp;&nbsp;CI/CD 배포 방식 및 시나리오

<br>



### 🧐 Blue/Green 방식을 사용한 이유 
&nbsp; `개발 초기 단계`인 점을 감안하여, `Blue/Green` 무중단 배포 기법을 선택하였다.  
&nbsp;  서비스 사용자 유입에 대한 예측과 사용자의 니즈를 파악하지 못한다는 점에서, 비교 대상군인 카나리와 비교해 봤을 때 레플리카셋 설정의 기준의 모호함을 감안하였다.  
&nbsp;  초기 새로운 기능의 개발 및 출시가 되었을 시, 개발자가 차마 예측하지 못한 다양한 에러에 대한 대응책으로, `이전 버전으로 롤백`이 가능하다는 점에서 현 초기 서비스와 적합하다고 판단하였다.  

### 🧐 추후 개선방향
#### Blue-Green 기법의 특성상 안고 가야할 과제는 다음과 같다.
&nbsp; 평상시에 어느 한쪽만을 이용한다는 것은, 인프라의 절반은 "놀고 있는" 상태가 된다는 것을 의미한다. 이는 비용적 측면에서 두 배의 차이를 보이기 때문에 적절한 레플리카셋으로 비용적 부담을 조절해야한다는 점이 있다.  

#### 만일, 서버의 크기와 사용자의 유입률이 증대가 된다면, 프론트엔드 측에 "카나리" 배포 기법 적용을 염두하고 있다.  
&nbsp; 직관적인 요소들로 사용자의 니즈를 파악할 수 있는 프론트엔드에서 새로운 버전 출시에 대한 A/B 테스트를 통해 어느쪽이 만족도가 높은지 추적하고 그에 따른 Release 방식을 채택함으로서, 사용자와 개발자 모두에게 좀 더 만족도 높은 기법으로 예상된다.  





<br>

<!--
#### ( 주의 ❗)
#### Blue/Green 방식으로 무중단 배포를 할 때, 만약 서버가 구동중인 상황이 클라우드나 가상환경이 아니라면? 정말 그냥 컴퓨터를 통해 물리적인 서버로 존재한다면? 
#### 기존에 있던 서버의 환경과 같은 수준의 서버를 두배로 늘렸다가 필요 없어지면 다시 줄이는 비 효율적인 방식을 선택할 수 없다. 한마디로, 물리적으로 존재하는 서버에서는 사용하기 어려우며 현재위치 배포 방식이 더 어울린다. Blue/Green방식은 쉽게 인스턴스를 생성하고 없앨 수 있는 클라우드 환경이나, 컨테이너를 올렸다가 내리는 것이 자유로운 Docker등의 가상환경에서 사용하는 것이 바람직하다.
-->


---

<!--
## 💻 CI/CD 시연 영상

<br>
<details>
<summary><b>🤵🏻‍♂️ Backend CI/CD </b></summary><br>
    <div>
    <details>
         <summary><b>Jenkins Pipeline</b></summary>
                  <br>
         <p><b>
          ➡ 백엔드 응답 메시지를 바꾸고 깃에 푸시
          ➡ 파이프라인이 작동
          ➡ 파드가 새로 생성
          ➡ 바뀐 응답메시지 확인
          </b></p><br>
         <p><img src="./img/backendPipeline.gif"/></p>
         </details>
    </div>
</details>
<br>
-->

<br>




<!--

## ✨ 프로젝트 기본 소개

<br>

### 프로젝트 배경
- 배경적기

### 프로젝트 목표
- 목표적기


<br>

---

## 📌 시연사이트 바로가기

### 📊 시연사이트링크넣기

<br>

-->


<!--
## &nbsp;📌 프로젝트 설명


### 👉&nbsp;&nbsp; Front
- LoadBalacer type의 서비스에 의해 외부에 연결되어 있다.
- nginx의 Reverse Proxy를 통해 front주소 /api가 붙어 있으면 k8s안의 Backend Service에 연결한다.
- 채팅 및 알람 기능은 연결을 지속적으로 유지하기 위해 http1.1이상 규격을 사용해야하며 nginx가 Reverse proxy 적용시 http1.1을 유지 하게 한다.
- 채팅의 경우 header가 http에서 ws로 upgrade 할 수 있도록 설정한다.
- Deployment로 k8s에서 작동하며 부하분산을 위해 2개의 pod로 운영된다.
- RollingUpdate 방식으로 무중단 배포 된다.

#### 🤔 [ Frontend 설명 더보기 ](https://github.com/beyond-sw-camp/be06-4th-SYNerge/wiki/Frontend)
<br>

### 👉&nbsp;&nbsp;Back
- SCDF에 의해 batch서버가 1분에 한번씩 pod로 작동하며, 이때 회원의 일정을 조회를 해서 메세지를 produce 하여 Cluster Ip를 통해 kafka broker로 전달한다. kafka broker는 Backend 서버에게 메세지를 전달하며, Backend는 메세지를 consume 하여 Frontend에게 SseEmitter를 통해 데이터를 전송한다.
- Deployment로 k8s에서 작동하며 부하분산을 위해 2개의 pod로 운영된다.
- 2개의 서버의 websocket session이 서로 달라 채팅 데이터가 누락이 될 수 있어, 채팅 메세지가 생성되면 kafka broker에게 전달하고 그 메세지를 2개의 서버가 consume한다.
- RollingUpdate 방식으로 무중단 배포 된다.
- Front, DB, kafka와 cluster ip로 통신하여 외부에 노출되지 않는다.

#### 🤔 [ Backend 설명 더보기 ](https://github.com/beyond-sw-camp/be06-4th-SYNerge/wiki/Backend)
<br>

### 👉&nbsp;&nbsp;CI/CD
- 개발자 Github에 push하게 되면, webhook에 의해 Jenkins가 작동한다.
- Jenkins는 pipeLine script에 따라 git clone, build, docker image build, docker image push의 과정을 거쳐 manifest 파일을 k8s master 서버 전송 후 deployment를 실행한다.

#### 🤔 [ CICD 설명 더보기 ](https://github.com/beyond-sw-camp/be06-4th-SYNerge/wiki/CI---CD)
-->
