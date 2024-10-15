<template>
  <div class="wrap">
    <div class="dimmed-background"></div>
    <div id="content" class="content" data-page="my-info">
      <div
        class="inner-w layout-split mobile-full"
        data-layout-split="orderlist"
        data-page="me-main"
      >
        <aside class="my-info">
          <div data-v-548edd38="" class="profile-area">
            <div
              data-v-548edd38=""
              class="outline PageMyPageProfileDesktop__image"
            >
              <label
                data-v-548edd38=""
                data-profile="image"
                class="img-bg profile-img"
                style="
                  background-image: url('https://image.idus.com/image/files/b5b721bcb181484797e726ba90503777.jpg');
                "
                ><input
                  data-v-548edd38=""
                  id="profile-image"
                  data-change-profile="image"
                  type="file"
                  name="image"
                  accept=".png, .jpg, .jpeg"
                  class="profile-image-input"
                />
                <span data-v-548edd38="" class="link-style">수정</span>
                <a
                  data-v-548edd38=""
                  href="/w/me/profile/image"
                  data-modal-trigger="modal-link"
                  data-modal-id="modal-profile"
                  class="profile-modal-open"
                  style="visibility: hidden"
                  >이미지 변경 모달</a
                ></label
              >
            </div>
            <div data-v-548edd38="" class="PageMyPageProfileDesktop__content">
              <a
                data-v-548edd38=""
                href="/v2/mypage/grade"
                class="PageMyPageProfileDesktop__content__grade"
                ><img
                  data-v-548edd38=""
                  src="https://cdn.idus.kr/static/common/images/20240524/073952_image_grade01.png"
                  class="PageMyPageProfileDesktop__content__grade__icon" />
                <span
                  data-v-548edd38=""
                  class="PageMyPageProfileDesktop__content__grade__text"
                >
                  아기손
                </span>
                <i
                  data-v-548edd38=""
                  class="idus-icon-arrow-right PageMyPageProfileDesktop__content__grade__arrow"
                ></i
              ></a>
              <strong
                data-v-548edd38=""
                data-profile="name"
                class="PageMyPageProfileDesktop__content__name"
              >
                김동욱
              </strong>
              <!---->
            </div>
          </div>

          <div class="my-point clf">
            <div class="point-coupon">
              <a href="/v2/mypage/point" class="inner fl">
                <span class="label">적립금</span>
                <em>0P</em>
              </a>
              <div class="divider"></div>
              <a href="/v2/mypage/coupon" class="fr">
                <span class="label">쿠폰</span>
                <em>3</em>
              </a>
            </div>
            <a
              href="/v2/mypage/gift-card-point"
              class="gift-card-point"
              data-log="gift-card-point"
            >
              <p class="label">기프트카드 포인트</p>
              <p class="point">0P</p>
            </a>
          </div>
          <div class="my-menu">
            <em>MY MENU</em>
            <nav>
              <b><span>주문 배송</span></b>
              <a
                href="/v2/mypage/order"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                주문/배송 내역
              </a>
              <b><span>알림 및 메시지</span></b>
              <a
                href="/v2/mypage/notification"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                알림
              </a>
              <a
                href="/w/message"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                메시지
              </a>
              <b><span>선물함</span></b>
              <a
                href="/v2/mypage/gift/receive"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                받은 선물함
              </a>
              <a
                href="/v2/mypage/gift/send"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                보낸 선물함
              </a>
              <b><span>기프트카드함</span></b>
              <a
                href="/v2/mypage/gift-card/receive"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                받은 카드함
              </a>
              <a
                href="/v2/mypage/gift-card/send"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                보낸 카드함
              </a>
              <b><span>나의 구매후기</span></b>
              <a
                href="/w/me/review/add"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                작성 가능한 후기
              </a>
              <a
                href="/w/me/review/all"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                작성한 후기
              </a>
              <b><span>관심</span></b>
              <a
                href="/v2/mypage/favorite/favorite-list"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                찜한 작품
              </a>
              <a
                href="/v2/mypage/favorite/follow-artist"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                팔로우하는 작가
              </a>
              <a
                href="/v2/mypage/favorite/recently-view"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                최근 본 작품
              </a>
              <b><span>할인혜택</span></b>
              <a
                href="/v2/mypage/membership"
                class=""
                data-log-object="dplus_membership"
                data-log="my-info-side-nav"
                target="_self"
              >
                d+ 멤버십
              </a>
              <a
                href="/w/event/main/point-payback"
                class=""
                data-log-object="idus_share"
                data-log="my-info-side-nav"
                target="_self"
              >
                idus share 적립금
              </a>
              <a
                href="/v2/mypage/coupon"
                class=""
                data-log-object="coupon"
                data-log="my-info-side-nav"
                target="_self"
              >
                쿠폰함
              </a>
              <a
                href="/v2/mypage/point"
                class=""
                data-log-object="point"
                data-log="my-info-side-nav"
                target="_self"
              >
                적립금
              </a>
              <a
                href="/v2/mypage/gift-card-point"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                기프트카드 포인트
              </a>
              <a
                href="/v2/mypage/invitation"
                class=""
                data-log-object="invite_friends"
                data-log="my-info-side-nav"
                target="_self"
              >
                친구 초대 쿠폰
              </a>
              <a
                href="https://bit.ly/3IDdeyE"
                class=""
                data-log-object="group_order"
                data-log="my-info-side-nav"
                target="_blank"
              >
                단체선물 문의
              </a>
              <b><span>내 정보</span></b>
              <a
                href="/mypage/grade"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                회원등급
              </a>
              <a
                href="/v2/mypage/edit-user-info"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                회원 정보 관리
              </a>
              <a
                href="/v2/mypage/payment-management"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                신용카드 및 환불계좌 관리
              </a>
              <a
                href="/v2/mypage/delivery"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                배송지 관리
              </a>
              <a
                href="/w/authorization"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                본인 인증
              </a>
              <a
                href="/w/logout"
                class=""
                data-log-object=""
                data-log="my-info-side-nav"
                target="_self"
              >
                로그아웃
              </a>
            </nav>
          </div>
        </aside>
        <section class="my-dashboard">
          <div class="title-style-bar">
            <h1 class="txt">내 정보</h1>
            <span class="subtxt"></span>
          </div>

          <ul class="dashboard-list">
            <li>
              <strong class="label">쿠폰</strong>
              <a href="/v2/mypage/coupon" class="value">3</a>
            </li>

            <li>
              <div class="title">
                <strong class="label">작가 발송 완료</strong>
                <div class="ui-dropdown right">
                  <button type="button" class="btn-dropdown" aria-label="?">
                    <i class="idus-icon-info"></i>
                  </button>
                  <div class="menu-dropdown">
                    <p class="para">최근 1개월 기준</p>
                  </div>
                </div>
              </div>
              <a href="/w/me/order/payment" class="value">0</a>
            </li>
            <li>
              <div class="title">
                <strong class="label">취소/환불 완료</strong>
                <div class="ui-dropdown right">
                  <button type="button" class="btn-dropdown" aria-label="?">
                    <i class="idus-icon-info"></i>
                  </button>
                  <div class="menu-dropdown">
                    <p class="para">최근 1개월 기준</p>
                  </div>
                </div>
              </div>
              <a href="/w/me/order/cancel" class="value">0</a>
            </li>
          </ul>

          <div class="title-style-sub">
            <h2 class="txt">최근 주문내역</h2>
            <a href="/w/me/order/payment" class="to-right link"
              >더보기<i class="idus-icon-arrow-right"></i
            ></a>
          </div>

          <p class="empty-msg">최근 1개월 이내에 주문한 작품이 없습니다.</p>

          <div class="btn-container">
            <a href="/w/me/order/payment" class="ui_btn--large"
              ><strong>최근 주문내역 더보기</strong></a
            >
          </div>

          <div class="ui_grid board-split">
            <div class="ui_grid__cols--2">
              <div class="ui_grid__item">
                <div class="title-style-sub">
                  <h2 class="txt">안 읽은 메시지</h2>
                  <a href="/w/message" class="to-right link"
                    >더보기<i class="idus-icon-arrow-right"></i
                  ></a>
                </div>
                <p class="empty-msg">모든 메시지를 읽었습니다.</p>
              </div>
              <div class="ui_grid__item">
                <div class="title-style-sub">
                  <h2 class="txt">알림</h2>
                  <a
                    data-log-object="see_all"
                    href="/v2/mypage/notification"
                    class="to-right link"
                    >더보기<i class="idus-icon-arrow-right"></i
                  ></a>
                </div>
                <ul class="msg-item-list-auto">
                  <div data-v-05795363="" class="notification_card_container">
                    <input
                      data-v-05795363=""
                      type="hidden"
                      name="paging_param"
                      value="4897099065"
                    />
                    <a
                      data-v-05795363=""
                      href="/w/product/427ceecd-d61f-49c3-9481-9dc0b40bab43"
                      class="notification_card_link"
                      ><img
                        data-v-05795363=""
                        src="https://image.idus.com/image/files/a5cd1396aa4e4a5a8057b1be6aa6216b.png"
                        class="notification_card_artist_img"
                      />
                      <div
                        data-v-05795363=""
                        class="notification_card_content_box"
                      >
                        <p data-v-05795363="" class="label">작품 할인</p>
                        <p data-v-05795363="" class="artist_name">
                          강릉은정한과
                        </p>
                        <p data-v-05795363="" class="message">
                          강릉은정한과님이 '[추석선물]정성담은
                          3단(+보자기)전통유과 #단체할인' 작품의 할인 판매를
                          시작하였습니다.
                        </p>
                      </div>
                      <p data-v-05795363="" class="notification_card_date">
                        9월 13일
                      </p></a
                    >
                  </div>

                  <div data-v-05795363="" class="notification_card_container">
                    <input
                      data-v-05795363=""
                      type="hidden"
                      name="paging_param"
                      value="4897091113"
                    />
                    <a
                      data-v-05795363=""
                      href="/w/product/713ff6c6-d724-49f4-a0a9-9e9993fb3dee"
                      class="notification_card_link"
                      ><img
                        data-v-05795363=""
                        src="https://image.idus.com/image/files/a5cd1396aa4e4a5a8057b1be6aa6216b.png"
                        class="notification_card_artist_img"
                      />
                      <div
                        data-v-05795363=""
                        class="notification_card_content_box"
                      >
                        <p data-v-05795363="" class="label">작품 할인</p>
                        <p data-v-05795363="" class="artist_name">
                          강릉은정한과
                        </p>
                        <p data-v-05795363="" class="message">
                          강릉은정한과님이 '[추석선물]만월3단(+보자기) 전통
                          유과#단체할인' 작품의 할인 판매를 시작하였습니다.
                        </p>
                      </div>
                      <p data-v-05795363="" class="notification_card_date">
                        9월 13일
                      </p></a
                    >
                  </div>

                  <div data-v-05795363="" class="notification_card_container">
                    <input
                      data-v-05795363=""
                      type="hidden"
                      name="paging_param"
                      value="4897065940"
                    />
                    <a
                      data-v-05795363=""
                      href="/w/product/e8ad30c4-cfa1-4716-b9d7-3bdb285df066"
                      class="notification_card_link"
                      ><img
                        data-v-05795363=""
                        src="https://image.idus.com/image/files/a5cd1396aa4e4a5a8057b1be6aa6216b.png"
                        class="notification_card_artist_img"
                      />
                      <div
                        data-v-05795363=""
                        class="notification_card_content_box"
                      >
                        <p data-v-05795363="" class="label">작품 할인</p>
                        <p data-v-05795363="" class="artist_name">
                          강릉은정한과
                        </p>
                        <p data-v-05795363="" class="message">
                          강릉은정한과님이 '[강릉한과/추석선물]찹쌀과줄조청듬뿍
                          당충전 대용량' 작품의 할인 판매를 시작하였습니다.
                        </p>
                      </div>
                      <p data-v-05795363="" class="notification_card_date">
                        9월 13일
                      </p></a
                    >
                  </div>
                </ul>
              </div>
            </div>
          </div>

          <div class="title-style-sub">
            <h2 class="txt">찜한 작품</h2>
            <a href="/v2/mypage/favorite/favorite-list" class="to-right link"
              >더보기<i class="idus-icon-arrow-right"></i
            ></a>
          </div>
          <div class="ui_grid">
            <ul class="ui_grid__cols--4">
              <li class="ui_grid__item">
                <div class="ui_card">
                  <button
                    type="button"
                    class="ui_card__overlay btn-ico sp-icon icon-favorite active"
                    aria-label="찜하기"
                    data-name="starred-toolbar"
                    data-starred-type="product"
                    data-init="1"
                    data-starred="1"
                    data-target-id="2bba02b5-14e9-4b14-8304-7c7ada3b7c72"
                    data-state="active"
                  ></button>

                  <div class="ui_card__imgcover">
                    <a
                      href="/w/product/2bba02b5-14e9-4b14-8304-7c7ada3b7c72"
                      target="_blank"
                      aria-label=""
                      class="ui_card__img"
                      data-product-id="2bba02b5-14e9-4b14-8304-7c7ada3b7c72"
                      style="
                        background-image: url('https://image.idus.com/image/files/37c9c62bdde744a0904e00e8706a170d_512.jpg');
                      "
                      data-was-processed="true"
                    ></a>
                  </div>

                  <div class="ui_card__info">
                    <a
                      href="/w/artist/503a1b15-8a20-4986-81fd-27b22853c400"
                      class="ui_card__label"
                      target="_blank"
                      >JJ달콤상회</a
                    >
                    <a
                      href="/w/product/2bba02b5-14e9-4b14-8304-7c7ada3b7c72"
                      class="ui_card__title"
                      target="_blank"
                      >추석 한가위 명절 전 쿠키 선물세트</a
                    >
                  </div>
                </div>
              </li>
            </ul>
          </div>

          <div class="title-style-sub">
            <h2 class="txt">팔로우하는 작가</h2>
            <a href="/v2/mypage/favorite/follow-artist" class="to-right link"
              >더보기<i class="idus-icon-arrow-right"></i
            ></a>
          </div>
          <ul class="artist-list">
            <li data-v-ebfdf1a6="" class="following-artist-container">
              <div data-v-ebfdf1a6="" class="artist-profile-area">
                <div
                  data-v-ebfdf1a6=""
                  class="artist-thumbnail"
                  style="
                    background-image: url('https://image.idus.com/image/files/a5cd1396aa4e4a5a8057b1be6aa6216b_324.png');
                  "
                >
                  <!---->
                </div>
                <div data-v-ebfdf1a6="" class="artist-profile">
                  <div data-v-ebfdf1a6="" class="text-area">
                    <h2 data-v-ebfdf1a6="" class="artist-name">강릉은정한과</h2>
                    <p data-v-ebfdf1a6="" class="artist-introduce">
                      "은정한과, 시간이 만든 맛(味)” 1,000년 역사의 전통 유과,
                      강릉 사천한과마을의 은정한과에서 맛을 이어오고 있습니다.
                      가득한 정(情), 은은한 달콤함, 조청의 깊은 맛(味)이
                      어우러진 은정한과로 오늘을 달콤하게 만나보세요.”
                    </p>
                  </div>
                  <button
                    data-v-6271e2da=""
                    data-v-ebfdf1a6=""
                    type="button"
                    class="following"
                    style="
                      background-color: rgb(255, 255, 255);
                      min-width: 96px;
                      width: 96px;
                      height: 32px;
                      font-size: 12px;
                      color: rgb(51, 51, 51);
                      border: 1px solid rgb(217, 217, 217);
                      border-radius: 4px;
                    "
                  >
                    <i
                      data-v-6271e2da=""
                      class="idus-icon-check"
                      style="font-size: 12px"
                    ></i>
                    팔로잉
                  </button>
                </div>
              </div>
              <div data-v-ebfdf1a6="" class="product-thumbnails">
                <a
                  data-v-ebfdf1a6=""
                  href="/w/artist/27e248b4-2d1b-45d0-9c8d-fdf77cc19b19/product"
                  target="_blank"
                  class="thumbnail-wrapper"
                  ><div
                    data-v-ebfdf1a6=""
                    data-size="512"
                    class="product-thumbnail"
                    data-src="https://image.idus.com/image/files/104533f9b18f42a18c476612f0b1180a.jpg"
                    lazy="loaded"
                    style="
                      background-image: url('https://image.idus.com/image/files/104533f9b18f42a18c476612f0b1180a_512.jpg');
                    "
                  ></div></a
                ><a
                  data-v-ebfdf1a6=""
                  href="/w/artist/27e248b4-2d1b-45d0-9c8d-fdf77cc19b19/product"
                  target="_blank"
                  class="thumbnail-wrapper"
                  ><div
                    data-v-ebfdf1a6=""
                    data-size="512"
                    class="product-thumbnail"
                    data-src="https://image.idus.com/image/files/68b2954ef7da47a28879224afb6a1a7d.jpg"
                    lazy="loaded"
                    style="
                      background-image: url('https://image.idus.com/image/files/68b2954ef7da47a28879224afb6a1a7d_512.jpg');
                    "
                  ></div></a
                ><a
                  data-v-ebfdf1a6=""
                  href="/w/artist/27e248b4-2d1b-45d0-9c8d-fdf77cc19b19/product"
                  target="_blank"
                  class="thumbnail-wrapper"
                  ><div
                    data-v-ebfdf1a6=""
                    data-size="512"
                    class="product-thumbnail"
                    data-src="https://image.idus.com/image/files/e8dfb2cc8a9649fa9c14df0c324a4f4b.jpg"
                    lazy="loaded"
                    style="
                      background-image: url('https://image.idus.com/image/files/e8dfb2cc8a9649fa9c14df0c324a4f4b_512.jpg');
                    "
                  ></div
                ></a>
              </div>
            </li>
          </ul>

          <div class="title-style-sub">
            <h2 class="txt">최근 본 작품</h2>
            <a
              data-log="recent-product-see-all"
              href="/v2/mypage/favorite/recently-view"
              class="to-right link"
              >더보기<i class="idus-icon-arrow-right"></i
            ></a>
          </div>
          <div class="ui_grid">
            <ul class="ui_grid__cols--4">
              <li
                class="ui_grid__item"
                data-log="recent-product-detail"
                data-log-product-uuid="f6edc07d-a647-4ac5-bbc0-f8d87f14e364"
                data-log-product-position="1"
              >
                <div class="ui_card">
                  <button
                    type="button"
                    class="ui_card__overlay btn-ico sp-icon icon-favorite"
                    aria-label="찜하기"
                    data-name="starred-toolbar"
                    data-starred-type="product"
                    data-init="1"
                    data-starred=""
                    data-target-id="f6edc07d-a647-4ac5-bbc0-f8d87f14e364"
                  ></button>

                  <div class="ui_card__imgcover">
                    <a
                      href="/w/product/f6edc07d-a647-4ac5-bbc0-f8d87f14e364"
                      target="_blank"
                      aria-label=""
                      class="ui_card__img"
                      data-product-id="f6edc07d-a647-4ac5-bbc0-f8d87f14e364"
                      style="
                        background-image: url('https://image.idus.com/image/files/d01f896b0d3a40828abdef728a652efe_512.jpg');
                      "
                      data-was-processed="true"
                    ></a>
                  </div>

                  <div class="ui_card__info">
                    <a
                      href="/w/artist/263e1069-8b3f-4d11-878a-9c5921291e93"
                      class="ui_card__label"
                      target="_blank"
                      >에버티</a
                    >
                    <a
                      href="/w/product/f6edc07d-a647-4ac5-bbc0-f8d87f14e364"
                      class="ui_card__title"
                      target="_blank"
                      >0kcal무설탕🍵말차 TEA에스프레소 액상말차베이스</a
                    >
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </section>
      </div>
    </div>

    <div></div>
    <a
      href="#header"
      class="to-top"
      data-ui="scroll-to-top"
      data-page=""
      style="display: none"
    >
      <img
        src="https://cdn.idus.kr/www/bea8026f3ead7488cdfe83f21970164e1b626158/resources/dist/images/go-to-top-image.png"
        alt="go to top"
        loading="lazy"
      />
    </a>
  </div>
</template>

<script>
export default {};
</script>
