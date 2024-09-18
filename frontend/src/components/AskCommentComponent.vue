<template>
  <div id="COMMENT" data-v-6da505b4="">
    <div data-v-6da505b4="">
      <!-------------��� ����-------------->

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
          <span class="subtitle1_bold_small">���</span>
        </div>
      </div>
      <!---------------------------��ۺ����ư----------------------------->
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
          <span class="CoreButton__text" data-v-524f63ea=""> ��� ������ </span>
        </div>
      </button>
      <!--------------------------��۸���Ʈ----------------------------------------------->
      <div
        v-for="(items, id) in askCommentStore.askCommentListAll"
        :key="id"
        class="text"
      >
        <div data-v-cb37c401="" class="CommentItem">
          <div data-v-cb37c401="" class="CommentItem__inner">
            <!------------------ ��� �� ������ �������̹���----------------------->
            <div
              data-v-2fc5c54e=""
              data-v-cb37c401=""
              class="BaseAvatar"
              style="
                --BaseAvatar-image: `url(${items.profileImageUrl}) `;
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
            <!-------------------������ �� ���Ǵ��------------------------------>
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
                  ��д���Դϴ�
                </div>
              </div>
            </div>
          </div>
          <!----------------------------�亯�� ���� ������ ���-------------------------------->
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
              <!-----------������ ������ �̹��� & �̸�----------------->
              <div data-v-c6b48237="" class="CommentItemReply__contentsUser">
                <div
                  data-v-2fc5c54e=""
                  data-v-c6b48237=""
                  class="BaseAvatar"
                  style="
                    --BaseAvatar-image: `url(
                        ${items.reply.replyAtelierProfileImageUrl}
                      )
                      `;
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
              <!-- ������ �亯 ���� -->

              <div
                v-if="items.secret === false"
                data-v-c6b48237=""
                class="CommentItemReply__contentsComment"
              >
                {{ items.reply.replyContent }}
              </div>
              <div v-else>��д���Դϴ�.</div>
            </div>
          </div>
        </div>
      </div>
      <!-------------------��� input â �� �Է¹�ư---------------------------------->
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
                placeholder="����� ���� �ּ���."
                class="BaseTextarea__textarea"
                data-v-be77401d=""
                style="height: 1px"
                v-model="textData"
                @input="checkTextLength"
              ></textarea>
            </div>
            <!----------------��� ��Ϲ�ư---------------------->
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
                <div class="CoreButton__text" data-v-524f63ea="">��д��</div>
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
                <span class="CoreButton__text" data-v-524f63ea=""> ��� </span>
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
import { useMemberStore } from "../stores/useMemberStore.js";
import { mapStores } from "pinia";

export default {
  name: "AskCommentComponent",
  components: {},
  data() {
    return {
      textData: "",
      isButtonActive: false, // ��ư Ȱ��ȭ ����
      isCreate: false,
    };
  },
  computed: {
    ...mapStores(useAskCommentStore),
    ...mapStores(useMemberStore),
  },
  created() {},
  async mounted() {
    console.log("mounted���Ӵ�");

    //������� �޼��� ȣ��
    await this.askCommentStore.readAllAskCommentList(
      this.askCommentStore.currentPage,
      this.askCommentStore.pageSize
    );

    this.checkTextLength(); // ������ �ε� �� ��ư ���� Ȯ��
  },
  methods: {
    // textarea�� ���� �� üũ
    checkTextLength() {
      this.isButtonActive = this.textData.length >= 3;
    },

    //textarea�� data�� ������ ������
    async sendContentToServer() {
      console.log("�Է°� ������������");
      if (this.memberStore.isLogined) {
        //�α����� ������ ��۾����ְ�
        if (!this.isButtonActive) return; // ��Ȱ��ȭ ���¿����� �������� ����
        try {
          await this.askCommentStore.createAskComment(this.textData);
          this.textData = ""; //�Է� �� �ʱ�ȭ
          this.isButtonActive = false; // �ʱ�ȭ �� ��ư ��Ȱ��ȭ
          !this.askCommentStore.isSecret;
          //��۸���Ʈ �ٽ� ��������
          await this.askCommentStore.readAllAskCommentList(0, 10);
          alert("����� �߰��Ǿ����ϴ�.");
        } catch (error) {
          console.log(error);
        }
      } else {
        //�α��ξ��� ������ �α����������� �̵�
        window.location.href = "http://localhost:3000/login";
      }
    },

    //��д��
    async sendSecretToServer() {
      if (!this.isButtonActive) return;
      try {
        if (this.askCommentStore.isSecret === true) {
          this.askCommentStore.isSecret = false;
          alert("��д���� ��ҵǾ����ϴ�");
        } else {
          this.askCommentStore.isSecret = true;
          alert("��д���� �����Ǿ����ϴ�.");
        }

        console.log("�������", this.askCommentStore.isSecret);
      } catch (error) {
        console.log(error);
      }
    },

    //��۴�����
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