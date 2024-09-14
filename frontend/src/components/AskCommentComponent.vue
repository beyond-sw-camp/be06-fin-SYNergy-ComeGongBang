<template>
  <div id="COMMENT" data-v-6da505b4="">
    <div data-v-6da505b4="">
      <!-------------댓글제목-------------->

      <div
        class="BaseSubHeader"
        style="
          --sub-header-padding-left: 0;
          --sub-header-padding-right: 0;
          --sub-header-min-height: 56;
        "
        data-v-b42a95d0=""
      >
        <div class="BaseSubHeader__contents" data-v-b42a95d0="">
          <span class="subtitle1_bold_small">댓글</span>
        </div>
      </div>
      <!---------------------------댓글보기버튼----------------------------->
      <!--  -->
      <button
        type="outline"
        class="CoreButton CoreButton--block BaseButtonRectangle body1-bold-small BaseButtonRectangle__outline mb-[12px]"
        style="
          background-color: rgb(255, 255, 255);
          color: rgb(51, 51, 51);
          height: 40px;
          flex-direction: row;
          --core-button-padding-x: 16;
          --button-rectangle-border-color: #acacac;
        "
        data-v-524f63ea=""
        data-v-7940d6dd=""
        v-if="
          askCommentStore &&
          askCommentStore.askCommentListAll &&
          askCommentStore.hasMore
        "
        @click="loadData"
      >
        <div class="inline-flex items-center" data-v-524f63ea="">
          <span class="CoreButton__text" data-v-524f63ea=""> 댓글 더보기 </span>
        </div>
      </button>
      <!--------------------------댓글리스트----------------------------------------------->
      <!-- <div v-if="askCommentListAll && askCommentListAll.length > 0">

      </div> -->
      <div
        v-for="(items, id) in askCommentStore.askCommentListAll"
        :key="id"
        class="text"
      >
        <div data-v-cb37c401="" class="CommentItem">
          <div data-v-cb37c401="" class="CommentItem__inner">
            <!------------------ 댓글 단 유저의 프로필이미지----------------------->
            <!-- items.profileImageUrl 로 변경하기 -->
            <div
              data-v-2fc5c54e=""
              data-v-cb37c401=""
              class="BaseAvatar"
              style="
                --BaseAvatar-image: url(//image.idus.com/image/files/b9fe2bc6a9b04ef5bc73cf4e008a3d12_320.jpg);
                --BaseAvatar-size: 32;
              "
            >
              <div data-v-2fc5c54e="" class="BaseAvatar__avatar">
                <div data-v-2fc5c54e="" class="BaseAvatar__avatarImage"></div>
              </div>
              <div
                data-v-8f163f81=""
                data-v-2fc5c54e=""
                class="CoreBadge BaseAvatar__iconDot"
                style="
                  --CoreBadge-color-background: #ef7014;
                  --CoreBadge-color-outline: #ffffff;
                  --CoreBadge-size: 6;
                  --CoreBadge-fontSize: 11;
                  --CoreBadge-offset-x: 0;
                  --CoreBadge-offset-y: 0;
                  --CoreBadge-position: relative;
                "
              ></div>
              <div
                data-v-8f163f81=""
                data-v-2fc5c54e=""
                class="CoreBadge CoreBadge__position--bottom BaseAvatar__iconCamera"
                style="
                  --CoreBadge-color-background: #000000;
                  --CoreBadge-color-outline: #ffffff;
                  --CoreBadge-size: 20;
                  --CoreBadge-fontSize: 11;
                  --CoreBadge-offset-x: 0;
                  --CoreBadge-offset-y: 0;
                  --CoreBadge-position: relative;
                "
              ></div>
            </div>
            <!-------------------유저가 단 문의댓글------------------------------>
            <div data-v-cb37c401="" class="CommentItem__innerContents">
              <div data-v-cb37c401="" class="CommentItem__innerContentsName">
                <span data-v-cb37c401="">{{ items.username }}</span>
              </div>
              <div v-if="items.secret === false">
                <div
                  data-v-cb37c401=""
                  class="CommentItem__innerContentsComment"
                >
                  {{ items.content }}
                </div>
              </div>
              <div v-else>
                <div
                  data-v-cb37c401=""
                  class="CommentItem__innerContentsComment"
                >
                  비밀댓글입니다
                </div>
              </div>
            </div>
          </div>
          <!----------------------------답변에 대한 주인장 답글-------------------------------->
          <div
            data-v-c6b48237=""
            data-v-cb37c401=""
            class="CommentItemReply ml-[40px] mt-[4px]"
            v-if="items.reply"
          >
            <div
              data-v-9783a2c9=""
              data-v-c6b48237=""
              class="BaseArrow"
              style="
                --area-height: 6;
                --arrow-size: 12;
                --arrow-top: 3;
                --arrow-left: 12;
                --arrow-color: #f5f5f5;
              "
            >
              <div data-v-9783a2c9="" class="BaseArrow__arrow"></div>
            </div>
            <div data-v-c6b48237="" class="CommentItemReply__contents">
              <!-----------주인장 프로필 이미지 & 이름----------------->
              <!-- items.replies.profileImageUrl 로 변경 -->
              <div data-v-c6b48237="" class="CommentItemReply__contentsUser">
                <div
                  data-v-2fc5c54e=""
                  data-v-c6b48237=""
                  class="BaseAvatar"
                  style="
                    --BaseAvatar-image: url(//image.idus.com/image/files/a24dedef7a804ca9a09e3faca246bd70_320.jpg);
                    --BaseAvatar-size: 24;
                  "
                >
                  <div data-v-2fc5c54e="" class="BaseAvatar__avatar">
                    <div
                      data-v-2fc5c54e=""
                      class="BaseAvatar__avatarImage"
                    ></div>
                  </div>
                  <div
                    data-v-8f163f81=""
                    data-v-2fc5c54e=""
                    class="CoreBadge BaseAvatar__iconDot"
                    style="
                      --CoreBadge-color-background: #ef7014;
                      --CoreBadge-color-outline: #ffffff;
                      --CoreBadge-size: 6;
                      --CoreBadge-fontSize: 11;
                      --CoreBadge-offset-x: 0;
                      --CoreBadge-offset-y: 0;
                      --CoreBadge-position: relative;
                    "
                  >
                    <!---->
                  </div>
                  <div
                    data-v-8f163f81=""
                    data-v-2fc5c54e=""
                    class="CoreBadge CoreBadge__position--bottom BaseAvatar__iconCamera"
                    style="
                      --CoreBadge-color-background: #000000;
                      --CoreBadge-color-outline: #ffffff;
                      --CoreBadge-size: 16;
                      --CoreBadge-fontSize: 11;
                      --CoreBadge-offset-x: 0;
                      --CoreBadge-offset-y: 0;
                      --CoreBadge-position: relative;
                    "
                  >
                    <!---->
                  </div>
                </div>
                <div
                  data-v-c6b48237=""
                  class="CommentItemReply__contentsUserName"
                >
                  {{ items.reply.replyAteliername }}
                </div>
              </div>
              <!-- 주인장 답변 내용 -->

              <div
                v-if="items.secret === false"
                data-v-c6b48237=""
                class="CommentItemReply__contentsComment"
              >
                {{ items.reply.replyContent }}
              </div>
              <div v-else>비밀댓글입니다.</div>
            </div>
          </div>
        </div>
      </div>
      <!-------------------댓글 input 창 및 입력버튼---------------------------------->
      <div class="pt-[16px]">
        <div class="BaseSend" data-v-04f97765="">
          <hr
            class="BaseDivider"
            style="--border-color: #f5f5f5"
            data-v-6ef4cf18=""
            data-v-04f97765=""
          />
          <!---->
          <div class="BaseSend__inputArea" data-v-04f97765="">
            <!---->
            <div
              class="BaseTextarea BaseTextarea__type--fill BaseTextarea__autoSize BaseTextarea__radius--medium BaseSend__textarea"
              style="
                --BaseTextarea-min-height: 39;
                --BaseTextarea-max-height: 100;
                --BaseTextarea-radius: 18;
              "
              data-v-be77401d=""
              data-v-04f97765=""
            >
              <div
                class="BaseLabelText BaseTextarea__label"
                style="display: none"
                data-v-e2593c18=""
                data-v-be77401d=""
              >
                <span class="BaseLabelText__text" data-v-e2593c18=""></span>
              </div>
              <textarea
                placeholder="댓글을 남겨 주세요."
                class="BaseTextarea__textarea"
                data-v-be77401d=""
                style="height: 1px"
                v-model="textData"
                @input="checkTextLength"
              ></textarea>
            </div>
            <!----------------댓글 등록버튼---------------------->
            <button
              type="default"
              style="
                background-color: transparent;
                color: black;
                height: 39px;
                flex-direction: row-reverse;
                justify-content: center;
                display: block;
                --core-button-padding-x: 8;
                --core-button-padding-y: 8;
                font-weight: bold;
                border: 1px solid lightgray;
                border-radius: 10px;
                padding: 10px;
                padding-right: 18px;
              "
              data-v-524f63ea=""
              data-v-8493c3f2=""
              data-v-04f97765=""
              :class="
                isButtonActive == true
                  ? 'CoreButton BaseButtonText body1-regular-small BaseSend__button active'
                  : 'CoreButton--disabled BaseButtonText--disabled BaseButtonText body1-regular-small BaseSend__button'
              "
              @click="sendSecretToServer"
            >
              <div class="inline-flex items-center" data-v-524f63ea="">
                <div class="CoreButton__text" data-v-524f63ea="">비밀댓글</div>
              </div>
            </button>
            <button
              type="default"
              style="
                background-color: transparent;
                color: black;
                height: 39px;
                flex-direction: row-reverse;
                font-weight: bold;
                border: 1px solid lightgray;
                border-radius: 10px;
                /* margin: 0px 10px 0px 10px; */
                padding: 0px 13px 0px 10px;
                --core-button-padding-x: 8;
              "
              data-v-524f63ea=""
              data-v-8493c3f2=""
              data-v-04f97765=""
              :class="
                isButtonActive == true
                  ? 'CoreButton BaseButtonText body1-regular-small BaseSend__button'
                  : 'CoreButton--disabled BaseButtonText--disabled BaseButtonText body1-regular-small BaseSend__button'
              "
              @click="sendContentToServer"
            >
              <div class="inline-flex items-center" data-v-524f63ea="">
                <span class="CoreButton__text" data-v-524f63ea=""> 등록 </span>
              </div>
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { useAskCommentStore } from "../stores/useAskCommentStore.js";
import { mapStores } from "pinia";
// import { ref } from "vue";

export default {
  name: "AskCommentComponent",
  components: {},
  data() {
    return {
      textData: "",
      isButtonActive: false, // 버튼 활성화 상태
      isCreate: false,
      id: 0,
    };
  },
  computed: {
    ...mapStores(useAskCommentStore),
  },
  created() {},
  async mounted() {
    console.log("mounted들어왓다");

    // await this.loadData();

    //스토어의 메서드 호출
    await this.askCommentStore.readAllAskCommentList(
      this.askCommentStore.currentPage,
      this.askCommentStore.pageSize
    );

    console.log("mount asklist", this.askCommentStore.askCommentListAll);
    this.checkTextLength(); // 페이지 로드 시 버튼 상태 확인
  },
  updated() {},
  methods: {
    // textarea의 글자 수 체크
    checkTextLength() {
      this.isButtonActive = this.textData.length >= 3;
    },

    //textarea의 data를 서버에 보내기
    async sendContentToServer() {
      console.log("입력값 서버에보내기");

      if (!this.isButtonActive) return; // 비활성화 상태에서는 전송하지 않음
      try {
        await this.askCommentStore.createAskComment(this.textData);
        this.textData = ""; //입력 후 초기화
        this.isButtonActive = false; // 초기화 후 버튼 비활성화
        !this.askCommentStore.isSecret;
        //댓글리스트 다시 가져오기
        console.log("데이터보내기함수 isCreate", this.askCommentStore.isCreate);
        await this.askCommentStore.readAllAskCommentList(0, 10);

        alert("댓글이 추가되었습니다.");
      } catch (error) {
        console.log(error);
      }
    },

    //비밀댓글
    async sendSecretToServer() {
      console.log("비밀댓글유무", this.askCommentStore.isSecret);

      if (!this.isButtonActive) return;
      try {
        if (this.askCommentStore.isSecret === true) {
          this.askCommentStore.isSecret = false;
          alert("비밀댓글이 취소되었습니다");
        } else {
          this.askCommentStore.isSecret = true;
          alert("비밀댓글이 설정되었습니다.");
        }

        console.log("비밀유무", this.askCommentStore.isSecret);
      } catch (error) {
        console.log(error);
      }
    },

    //댓글더보기
    async loadData() {
      await this.askCommentStore.readAllAskCommentList(
        this.askCommentStore.currentPage,
        this.askCommentStore.pageSize
      );
    },
  },
};
</script>
<style scoped>
.text {
  text-align: left;
}
</style>