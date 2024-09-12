<template>
    <div id="__nuxt">
        <div class="appContainer full"
            style="--desktop-header-menu-top: 75px; --desktop-header-sticky-height: 76px; --container-background-color: #f5f5f5;"
            data-v-4e58ad83="">
            <div class="appContents" data-v-4e58ad83=""><!--[-->
                <div data-v-8fded032="" class="Cart" style="--desktop-cart-header-height: 48px;">
                    <div data-v-a5290452="" data-v-8fded032="" class="PageCartDesktop"
                        style="--desktop-cart-fab-width: undefinedpx;"><!---->
                        <!-- 로딩창 -->
                        <div v-if="cartStore.loading" class="BaseOverlay z-[1000]"
                            style="--BaseOverlay-position:fixed;--BaseOverlay-background:rgba(245, 245, 245, 0.6);--BaseOverlay-blur:blur(0px);"
                            data-v-546911c4="" data-v-a5290452="">
                            <div class="BaseOverlay__scrim" data-v-546911c4=""></div>
                            <div class="BaseOverlay__content" data-v-546911c4="">
                                <div class="flex justify-center items-center" data-v-a5290452="">
                                    <div class="relative w-full" data-v-a5290452="">
                                        <div class="BaseProgressIndicator flex justify-center items-center w-full h-[108px]"
                                            data-v-a5290452="" data-v-3e1417ba="">
                                            <div class="BaseLoaderCircle" style="width:48px;height:48px;"
                                                data-v-d3ab2c08="" data-v-3e1417ba=""><svg viewBox="0 0 50 50"
                                                    class="BaseLoaderCircle__inner" data-v-d3ab2c08="">
                                                    <circle
                                                        class="BaseLoaderCircle__innerCircle BaseLoaderCircle__innerCircle--underlay"
                                                        cx="50%" cy="50%" r="20" data-v-d3ab2c08=""></circle>
                                                    <circle
                                                        class="BaseLoaderCircle__innerCircle BaseLoaderCircle__innerCircle--overlay"
                                                        cx="50%" cy="50%" r="20" data-v-d3ab2c08=""></circle>
                                                </svg></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- 장바구니  01장바구니 > 주문 > 결제 -->
                        <div data-v-a5290452="" class="flex flex-col items-center white--background py-[30px]">
                            <div data-v-a5290452="" class="flex justify-between h-[34px] w-[1280px]">
                                <div data-v-a5290452="" class="headline4-bold-small">장바구니</div>
                                <div data-v-efa8f703="" data-v-a5290452="" class="DesktopOrderStepper">
                                    <div data-v-efa8f703="" class="flex DesktopOrderStepper--active">
                                        <div data-v-efa8f703="" class="mr-[8px]">01</div>
                                        <div data-v-efa8f703="" class="mr-[8px]">장바구니</div>
                                    </div><svg data-v-6d2bd019="" data-v-efa8f703="" width="24" height="24"
                                        viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"
                                        class="BaseIcon mr-[8px] last:hidden"
                                        style="width: 20px; height: 20px; opacity: 1; fill: currentcolor; --BaseIcon-color: #d9d9d9;">
                                        <g clip-path="url(#clip0_124_2947)">
                                            <path fill-rule="evenodd" clip-rule="evenodd"
                                                d="M9.53039 5.46973L15.5304 11.4697C15.7967 11.736 15.8209 12.1527 15.603 12.4463L15.5304 12.5304L9.53039 18.5304L8.46973 17.4697L13.9391 12.0001L8.46973 6.53039L9.53039 5.46973Z">
                                            </path>
                                        </g>
                                        <defs>
                                            <clipPath id="clip0_124_2947">
                                                <rect width="24" height="24"></rect>
                                            </clipPath>
                                        </defs>
                                    </svg>
                                    <div data-v-efa8f703="" class="flex">
                                        <div data-v-efa8f703="" class="mr-[8px]">02</div>
                                        <div data-v-efa8f703="" class="mr-[8px]">주문 결제</div>
                                    </div><svg data-v-6d2bd019="" data-v-efa8f703="" width="24" height="24"
                                        viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"
                                        class="BaseIcon mr-[8px] last:hidden"
                                        style="width: 20px; height: 20px; opacity: 1; fill: currentcolor; --BaseIcon-color: #d9d9d9;">
                                        <g clip-path="url(#clip0_124_2947)">
                                            <path fill-rule="evenodd" clip-rule="evenodd"
                                                d="M9.53039 5.46973L15.5304 11.4697C15.7967 11.736 15.8209 12.1527 15.603 12.4463L15.5304 12.5304L9.53039 18.5304L8.46973 17.4697L13.9391 12.0001L8.46973 6.53039L9.53039 5.46973Z">
                                            </path>
                                        </g>
                                        <defs>
                                            <clipPath id="clip0_124_2947">
                                                <rect width="24" height="24"></rect>
                                            </clipPath>
                                        </defs>
                                    </svg>
                                    <div data-v-efa8f703="" class="flex">
                                        <div data-v-efa8f703="" class="mr-[8px]">03</div>
                                        <div data-v-efa8f703="" class="mr-[8px]">주문 완료</div>
                                    </div><svg data-v-6d2bd019="" data-v-efa8f703="" width="24" height="24"
                                        viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"
                                        class="BaseIcon mr-[8px] last:hidden"
                                        style="width: 20px; height: 20px; opacity: 1; fill: currentcolor; --BaseIcon-color: #d9d9d9;">
                                        <g clip-path="url(#clip0_124_2947)">
                                            <path fill-rule="evenodd" clip-rule="evenodd"
                                                d="M9.53039 5.46973L15.5304 11.4697C15.7967 11.736 15.8209 12.1527 15.603 12.4463L15.5304 12.5304L9.53039 18.5304L8.46973 17.4697L13.9391 12.0001L8.46973 6.53039L9.53039 5.46973Z">
                                            </path>
                                        </g>
                                        <defs>
                                            <clipPath id="clip0_124_2947">
                                                <rect width="24" height="24"></rect>
                                            </clipPath>
                                        </defs>
                                    </svg>
                                </div>
                            </div>
                        </div>

                        <!-- 전체 선택 -->
                        <div data-v-a5290452="" class="PageCartDesktop__allCheck">
                            <div data-v-a5290452="" class="flex justify-start w-[1280px]">
                                <div data-v-a5290452=""
                                    class="flex items-center justify-between white--background w-[850px] PageCartDesktop__allCheckControl">
                                    <div>
                                        <label data-v-ee180726=""
                                            :class="allCart ? 'BaseCheckbox BaseCheckbox__size--small BaseCheckbox__verticalAlign--center BaseCheckbox__state--checked my-[8px]'
                                                : 'BaseCheckbox BaseCheckbox__size--small BaseCheckbox__verticalAlign--center BaseCheckbox__state--unChecked my-[8px]'"
                                            style="--BaseCheckbox--label-margin: 8;">
                                            <div data-v-ee180726="" class="BaseCheckbox__wrapper">
                                                <input @change="toggleAll" data-v-ee180726=""
                                                    class="BaseCheckbox__input" type="checkbox"><span data-v-ee180726=""
                                                    class="BaseCheckbox__button"><svg data-v-6d2bd019=""
                                                        data-v-ee180726="" width="24" height="24" viewBox="0 0 24 24"
                                                        xmlns="http://www.w3.org/2000/svg"
                                                        class="BaseIcon BaseCheckbox__icon"
                                                        :style="allCart ? 'width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #ffffff;'
                                                            : 'width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #d9d9d9;'">
                                                        <g clip-path="url(#clip0_2582_8708)">
                                                            <path fill-rule="evenodd" clip-rule="evenodd"
                                                                d="M7.76086 11.5393L10.1343 13.9131L16.2648 7.7827L17.3255 8.84336L10.6648 15.504C10.3964 15.7725 9.97496 15.7948 9.68099 15.5711L9.60419 15.504L6.7002 12.6L7.76086 11.5393Z">
                                                            </path>
                                                        </g>
                                                        <defs>
                                                            <clipPath id="clip0_2582_8708">
                                                                <rect width="24" height="24"></rect>
                                                            </clipPath>
                                                        </defs>
                                                    </svg></span><span data-v-ee180726="" class="BaseCheckbox__text"
                                                    style="color: rgb(51, 51, 51);">전체선택 (3/3개)</span>
                                            </div>
                                        </label>
                                    </div>
                                    <div><button data-v-524f63ea="" data-v-7940d6dd="" type="outline"
                                            class="CoreButton BaseButtonRectangle body3-regular-small BaseButtonRectangle__outline"
                                            style="background-color: rgb(255, 255, 255); color: rgb(51, 51, 51); height: 28px; flex-direction: row; --core-button-padding-x: 8; --button-rectangle-border-color: #acacac;"><!----><!---->
                                            <div data-v-524f63ea="" class="inline-flex items-center"><span
                                                    data-v-524f63ea="" class="CoreButton__text">선택삭제</span></div>
                                        </button></div>
                                </div>
                            </div>
                        </div>

                        <!-- 메인 컨텐츠  -->
                        <div data-v-a5290452="" class="flex justify-center mb-[30px]">
                            <div data-v-a5290452="" class="w-[850px] min-h-[550px]">


                                <!-- 장바구니 작가 반복 -->
                                <div v-for="atelier in cartStore.cartList" :key="atelier.atelierIdx" data-v-db78b45c=""
                                    data-v-a5290452="" class="CartArtist CartArtist--sticky"
                                    id="cart_artist_eacceac9-7992-43db-af29-fb383c7fced9"
                                    style="--desktop-cart-artist-sticky-height: 78px;">

                                    <!-- 공방 이름 -->
                                    <div data-v-db78b45c="" class="CartArtist__header">
                                        <div data-v-db78b45c="" class="CartArtist__headerInner">
                                            <div data-v-db78b45c="" class="flex items-center justify-between h-[56px]">
                                                <div data-v-db78b45c="" class="flex items-center">
                                                    <label data-v-ee180726="" data-v-db78b45c=""
                                                        :class="atelier.checked ? 'BaseCheckbox BaseCheckbox__size--small BaseCheckbox__verticalAlign--center BaseCheckbox__state--checked my-[8px]'
                                                            : 'BaseCheckbox BaseCheckbox__size--small BaseCheckbox__verticalAlign--center BaseCheckbox__state--unChecked my-[8px]'"
                                                        style="--BaseCheckbox--label-margin: 8;">
                                                        <div data-v-ee180726="" class="BaseCheckbox__wrapper">
                                                            <input @change="toggleAtelier(atelier)" data-v-ee180726=""
                                                                class="BaseCheckbox__input" type="checkbox"><span
                                                                data-v-ee180726="" class="BaseCheckbox__button"><svg
                                                                    data-v-6d2bd019="" data-v-ee180726="" width="24"
                                                                    height="24" viewBox="0 0 24 24"
                                                                    xmlns="http://www.w3.org/2000/svg"
                                                                    class="BaseIcon BaseCheckbox__icon"
                                                                    :style="atelier.checked ? 'width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #ffffff;'
                                                                        : 'width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #d9d9d9;'">
                                                                    <g clip-path="url(#clip0_2582_8708)">
                                                                        <path fill-rule="evenodd" clip-rule="evenodd"
                                                                            d="M7.76086 11.5393L10.1343 13.9131L16.2648 7.7827L17.3255 8.84336L10.6648 15.504C10.3964 15.7725 9.97496 15.7948 9.68099 15.5711L9.60419 15.504L6.7002 12.6L7.76086 11.5393Z">
                                                                        </path>
                                                                    </g>
                                                                    <defs>
                                                                        <clipPath id="clip0_2582_8708">
                                                                            <rect width="24" height="24"></rect>
                                                                        </clipPath>
                                                                    </defs>
                                                                </svg></span><span data-v-ee180726=""
                                                                class="BaseCheckbox__text"
                                                                style="color: rgb(51, 51, 51);"></span>
                                                        </div>
                                                    </label>
                                                    <div data-v-db78b45c="" class="flex cursor-pointer">
                                                        <div data-v-db78b45c=""
                                                            class="subtitle3-bold-medium line-clamp-1">{{
                                                                atelier.atelierName }}</div><svg data-v-6d2bd019=""
                                                            data-v-db78b45c="" width="24" height="24"
                                                            viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"
                                                            class="BaseIcon"
                                                            style="width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333;">
                                                            <g clip-path="url(#clip0_124_2947)">
                                                                <path fill-rule="evenodd" clip-rule="evenodd"
                                                                    d="M9.53039 5.46973L15.5304 11.4697C15.7967 11.736 15.8209 12.1527 15.603 12.4463L15.5304 12.5304L9.53039 18.5304L8.46973 17.4697L13.9391 12.0001L8.46973 6.53039L9.53039 5.46973Z">
                                                                </path>
                                                            </g>
                                                            <defs>
                                                                <clipPath id="clip0_124_2947">
                                                                    <rect width="24" height="24"></rect>
                                                                </clipPath>
                                                            </defs>
                                                        </svg>
                                                    </div>
                                                </div>
                                                <div data-v-db78b45c="" class="flex flex-col items-end">
                                                    <div>
                                                        <div data-v-a1957620=""
                                                            class="BaseDecorateText transform-gpu whitespace-pre inline flex ml-[4px]">
                                                            <span data-v-a1957620="" class="DecorateText__badge"><!---->
                                                                <div data-v-c3bdd300="" data-v-a1957620=""
                                                                    class="BaseBadgeFreeShipping"
                                                                    style="--icon-width: 48; --icon-height: 18;">
                                                                    <div data-v-c3bdd300=""
                                                                        class="BaseBadgeFreeShipping__icon"></div>
                                                                </div>
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <div class="flex items-center justify-end mt-[4px]"></div>
                                                </div>
                                            </div>
                                            <div data-v-db78b45c="" class="pb-[8px] h-[14px]" style="display: none;">
                                                <div data-v-cb06afdd="" data-v-db78b45c=""
                                                    class="ProgressBar__container ProgressBar__colorType--blue"
                                                    style="--progress-bar-height: 6px; --progress-bar-bar-rate: 100%; --progress-bar-border-radius: 3px;">
                                                    <div data-v-cb06afdd="" class="ProgressBar">
                                                        <div data-v-cb06afdd="" class="ProgressBar__bar transform-gpu">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- 공방 컨텐츠 -->
                                    <div data-v-db78b45c="" class="CartArtist__contents">
                                        <hr data-v-6ef4cf18="" data-v-db78b45c="" class="BaseDivider"
                                            style="--border-color: #f5f5f5;">
                                        <div data-v-db78b45c=""><!---->

                                            <!-- 상품 반복 -->
                                            <div v-for="product in atelier.productList" :key="product.productIdx"
                                                data-v-8cd67775="" data-v-db78b45c="">
                                                <div data-v-8cd67775=""
                                                    class="flex items-start justify-between w-full py-[12px] px-[16px]">

                                                    <!-- 사진 -->
                                                    <div data-v-8cd67775="" class="flex items-start">
                                                        <label data-v-ee180726="" data-v-8cd67775=""
                                                            :class="product.checked ? 'BaseCheckbox BaseCheckbox__size--small BaseCheckbox__verticalAlign--center BaseCheckbox__state--checked my-[8px]'
                                                                : 'BaseCheckbox BaseCheckbox__size--small BaseCheckbox__verticalAlign--center BaseCheckbox__state--unChecked my-[8px]'"
                                                            style="--BaseCheckbox--label-margin: 8;">
                                                            <div data-v-ee180726="" class="BaseCheckbox__wrapper">
                                                                <input @change="toggleProduct(atelier, product)"
                                                                    data-v-ee180726="" class="BaseCheckbox__input"
                                                                    type="checkbox"><span data-v-ee180726=""
                                                                    class="BaseCheckbox__button"><svg data-v-6d2bd019=""
                                                                        data-v-ee180726="" width="24" height="24"
                                                                        viewBox="0 0 24 24"
                                                                        xmlns="http://www.w3.org/2000/svg"
                                                                        class="BaseIcon BaseCheckbox__icon"
                                                                        :style="product.checked ? 'width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #ffffff;'
                                                                            : 'width: 24px; height: 24px; opacity: 1; fill: currentcolor; --BaseIcon-color: #d9d9d9;'">
                                                                        <g clip-path="url(#clip0_2582_8708)">
                                                                            <path fill-rule="evenodd"
                                                                                clip-rule="evenodd"
                                                                                d="M7.76086 11.5393L10.1343 13.9131L16.2648 7.7827L17.3255 8.84336L10.6648 15.504C10.3964 15.7725 9.97496 15.7948 9.68099 15.5711L9.60419 15.504L6.7002 12.6L7.76086 11.5393Z">
                                                                            </path>
                                                                        </g>
                                                                        <defs>
                                                                            <clipPath id="clip0_2582_8708">
                                                                                <rect width="24" height="24"></rect>
                                                                            </clipPath>
                                                                        </defs>
                                                                    </svg></span><span data-v-ee180726=""
                                                                    class="BaseCheckbox__text"
                                                                    style="color: rgb(51, 51, 51);"></span>
                                                            </div>
                                                        </label>
                                                        <div data-v-8cd67775="" class="CartArtistProduct__image">
                                                            <div data-v-24b1dfb3="" data-v-8cd67775=""
                                                                class="BaseImage BaseImage__fixedWidth BaseImage__fixedHeight cursor-pointer"
                                                                style="--BaseImage-width: 64; --BaseImage-height: 64; --BaseImage-radius: 2;">
                                                                <div data-v-24b1dfb3="" class="BaseImage__image"
                                                                    style="background-image: url(&quot;https://image.idus.com/image/files/eb752e371c5b459097e189311ffddd46_320.jpg&quot;);">
                                                                    <img data-v-24b1dfb3=""
                                                                        src="https://image.idus.com/image/files/eb752e371c5b459097e189311ffddd46_320.jpg"
                                                                        class="hidden" loading="lazy">
                                                                </div>
                                                            </div><!---->
                                                        </div>
                                                    </div>

                                                    <!-- 상품 설명 본문 -->
                                                    <div data-v-8cd67775="" class="flex flex-col flex-auto ml-[12px]"
                                                        style="text-align: left">

                                                        <!-- 상품 제목 -->
                                                        <div data-v-8cd67775="" class="flex cursor-pointer">
                                                            <div data-v-8cd67775="" class="flex flex-col flex-auto">
                                                                <div data-v-8cd67775="" class="flex mb-[4px]">
                                                                    <div data-v-1cb18953="" data-v-8cd67775=""
                                                                        class="BaseBadge BaseBadge__style--membershipTextColor BaseBadge__style--membershipBackgroundColor BaseBadge__style--round flex mr-[4px] last:ml-0"
                                                                        style="--badge-color: #FF4B50; --badge-background-color: #FFF2F4;">
                                                                        <img data-v-1cb18953=""
                                                                            src="https://cdn.idus.kr/static/common/images/20240522/063418_icon_discount.png"
                                                                            class="h-[12px] mr-[2px]">
                                                                        <div data-v-1cb18953="" class="BaseBadge__text">
                                                                            10% 즉시할인</div>
                                                                    </div>
                                                                </div>
                                                                <div data-v-8cd67775="" class="body1-regular-small">
                                                                    {{ product.productName }}</div>
                                                                <div data-v-8cd67775=""
                                                                    class="body3-regular-medium gray-999--text">주문시 제작
                                                                </div>
                                                            </div><!---->
                                                        </div>


                                                        <div data-v-8cd67775="" class="flex flex-col w-full">

                                                            <!-- 같은 상품의 여러 옵션들 -->
                                                            <div v-for="option in product.optionList"
                                                                :key="option.cartIdx" data-v-6df967a0=""
                                                                data-v-8cd67775=""
                                                                class="flex justify-between w-full py-[16px]">

                                                                <!-- 상품 옵션 리스트 whitespace-pre-line 옵션 뻄-->
                                                                <div v data-v-6df967a0=""
                                                                    class="body3-regular-small gray-666--text ">

                                                                    <p v-for="optionDetail in option.subOptionsList"
                                                                        :key="optionDetail.cartIdx">
                                                                        - {{ optionDetail.majorOptionName }} : {{
                                                                            optionDetail.subOptionName }}

                                                                    </p>
                                                                </div>

                                                                <!-- 옵션 선택 -->
                                                                <div data-v-6df967a0=""
                                                                    class="flex items-start justify-between">
                                                                    <div data-v-6df967a0="" class="flex flex-col">
                                                                        <div data-v-6df967a0=""
                                                                            class="flex items-center pl-[20px]"><button
                                                                                data-v-524f63ea="" data-v-7940d6dd=""
                                                                                data-v-6df967a0="" type="outline"
                                                                                class="CoreButton BaseButtonRectangle body3-regular-small BaseButtonRectangle__outline min-w-[60px]"
                                                                                style="background-color: rgb(255, 255, 255); color: rgb(51, 51, 51); height: 32px; flex-direction: row; --core-button-padding-x: 8; --button-rectangle-border-color: #acacac;"><!----><!---->
                                                                                <div data-v-524f63ea=""
                                                                                    class="inline-flex items-center">
                                                                                    <span data-v-524f63ea=""
                                                                                        class="CoreButton__text">옵션변경</span>
                                                                                </div>
                                                                            </button>
                                                                            <div data-v-c2d3b141="" data-v-6df967a0=""
                                                                                class="Count ml-[8px]">
                                                                                <div data-v-c2d3b141=""
                                                                                    class="h-full border-r-[1px] border-[#f5f5f5]">
                                                                                    <button
                                                                                        @click="decreaseQuantity(option)"
                                                                                        data-v-524f63ea=""
                                                                                        data-v-778c1d9b=""
                                                                                        data-v-c2d3b141="" type="button"
                                                                                        class="CoreButton CoreButton BaseButtonIcon gray-f5--background"
                                                                                        style="background-color: transparent; height: 30px; width: 30px; flex-direction: column;"><!----><svg
                                                                                            data-v-6d2bd019=""
                                                                                            data-v-524f63ea=""
                                                                                            width="24" height="24"
                                                                                            viewBox="0 0 24 24"
                                                                                            xmlns="http://www.w3.org/2000/svg"
                                                                                            class="BaseIcon CoreButton__icon"
                                                                                            style="width: 20px; height: 20px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-bottom: 0px;">
                                                                                            <g
                                                                                                clip-path="url(#clip0_124_2961)">
                                                                                                <path
                                                                                                    fill-rule="evenodd"
                                                                                                    clip-rule="evenodd"
                                                                                                    d="M19 11.25V12.75H5V11.25H19Z">
                                                                                                </path>
                                                                                            </g>
                                                                                            <defs>
                                                                                                <clipPath
                                                                                                    id="clip0_124_2961">
                                                                                                    <rect width="24"
                                                                                                        height="24">
                                                                                                    </rect>
                                                                                                </clipPath>
                                                                                            </defs>
                                                                                        </svg>
                                                                                        <div data-v-524f63ea=""
                                                                                            class="inline-flex items-center">
                                                                                            <!---->
                                                                                        </div>
                                                                                    </button>
                                                                                </div>
                                                                                <select @change="updateQuantity(option)"
                                                                                    data-v-c2d3b141=""
                                                                                    class="Count__select"
                                                                                    v-model="option.count">
                                                                                    <option v-for="n in 100" :key="n"
                                                                                        :value="n">{{ n }}</option>
                                                                                </select>
                                                                                <div data-v-c2d3b141=""
                                                                                    class="h-full border-l-[1px] border-[#f5f5f5]">
                                                                                    <button
                                                                                        @click="increaseQuantity(option)"
                                                                                        data-v-524f63ea=""
                                                                                        data-v-778c1d9b=""
                                                                                        data-v-c2d3b141="" type="button"
                                                                                        class="CoreButton BaseButtonIcon"
                                                                                        style="background-color: transparent; color: rgb(51, 51, 51); height: 30px; width: 30px; flex-direction: column;"><!----><svg
                                                                                            data-v-6d2bd019=""
                                                                                            data-v-524f63ea=""
                                                                                            width="24" height="24"
                                                                                            viewBox="0 0 24 24"
                                                                                            xmlns="http://www.w3.org/2000/svg"
                                                                                            class="BaseIcon CoreButton__icon"
                                                                                            style="width: 20px; height: 20px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-bottom: 0px;">
                                                                                            <g
                                                                                                clip-path="url(#clip0_124_2960)">
                                                                                                <path
                                                                                                    fill-rule="evenodd"
                                                                                                    clip-rule="evenodd"
                                                                                                    d="M12.75 5V11.25H19V12.75H12.75V19H11.25V12.75H5V11.25H11.25V5H12.75Z">
                                                                                                </path>
                                                                                            </g>
                                                                                            <defs>
                                                                                                <clipPath
                                                                                                    id="clip0_124_2960">
                                                                                                    <rect width="24"
                                                                                                        height="24">
                                                                                                    </rect>
                                                                                                </clipPath>
                                                                                            </defs>
                                                                                        </svg>
                                                                                        <div data-v-524f63ea=""
                                                                                            class="inline-flex items-center">
                                                                                            <!---->
                                                                                        </div>
                                                                                    </button>
                                                                                </div>
                                                                            </div>
                                                                        </div><!---->
                                                                    </div>
                                                                    <div data-v-6df967a0=""
                                                                        class="flex items-center justify-between h-[32px]">
                                                                        <div data-v-6df967a0=""><!---->
                                                                            <div data-v-6df967a0=""
                                                                                class="body1-bold-small w-[120px] ml-[20px] text-right">
                                                                                {{ option.price * option.count }}원</div>
                                                                        </div><button data-v-524f63ea=""
                                                                            data-v-778c1d9b="" data-v-6df967a0=""
                                                                            type="button"
                                                                            class="CoreButton BaseButtonIcon ml-[12px]"
                                                                            style="background-color: transparent; color: rgb(153, 153, 153); height: 20px; flex-direction: column;"><!----><svg
                                                                                data-v-6d2bd019="" data-v-524f63ea=""
                                                                                width="24" height="24"
                                                                                viewBox="0 0 24 24"
                                                                                xmlns="http://www.w3.org/2000/svg"
                                                                                class="BaseIcon CoreButton__icon"
                                                                                style="width: 20px; height: 20px; opacity: 1; fill: currentcolor; --BaseIcon-color: #333333; margin-bottom: 0px;">
                                                                                <g clip-path="url(#clip0_124_2945)">
                                                                                    <path fill-rule="evenodd"
                                                                                        clip-rule="evenodd"
                                                                                        d="M18.4697 4.46973L19.5303 5.53039L13.0597 11.9997L19.5303 18.4697L18.4697 19.5304L11.9997 13.0597L5.53033 19.5304L4.46967 18.4697L10.9397 11.9997L4.46967 5.53039L5.53033 4.46973L11.9997 10.9397L18.4697 4.46973Z">
                                                                                    </path>
                                                                                </g>
                                                                                <defs>
                                                                                    <clipPath id="clip0_124_2945">
                                                                                        <rect width="24" height="24">
                                                                                        </rect>
                                                                                    </clipPath>
                                                                                </defs>
                                                                            </svg>
                                                                            <div data-v-524f63ea=""
                                                                                class="inline-flex items-center"><!---->
                                                                            </div>
                                                                        </button>
                                                                    </div>
                                                                </div>

                                                            </div>

                                                            <hr data-v-6ef4cf18="" data-v-8cd67775=""
                                                                class="BaseDivider last:hidden"
                                                                style="--border-color: #f5f5f5;">
                                                        </div>

                                                        <!-- 주문 요청 사항 -->
                                                        <div data-v-8cd67775="" class="pt-[4px] pb-[16px]">
                                                            <div data-v-be77401d=""
                                                                class="BaseTextarea BaseTextarea__type--outline BaseTextarea__fixedSize--small flex-auto"
                                                                style="--BaseTextarea-min-height: 0; --BaseTextarea-max-height: 0; --BaseTextarea-radius: 2;">
                                                                <div data-v-e2593c18="" data-v-be77401d=""
                                                                    class="BaseLabelText BaseTextarea__label"
                                                                    style="display: none;">
                                                                    <span data-v-e2593c18=""
                                                                        class="BaseLabelText__text"></span><!---->
                                                                </div>
                                                                <textarea data-v-be77401d=""
                                                                    placeholder="주문 요청사항을 500자 내로 입력해주세요." readonly=""
                                                                    class="BaseTextarea__textarea"></textarea><!---->
                                                            </div>
                                                            <div class="flex" style="display: none;">
                                                                <div data-v-be77401d=""
                                                                    class="BaseTextarea BaseTextarea__type--outline BaseTextarea__fixedSize--small flex-auto"
                                                                    style="--BaseTextarea-min-height: 0; --BaseTextarea-max-height: 0; --BaseTextarea-radius: 2;">
                                                                    <div data-v-e2593c18="" data-v-be77401d=""
                                                                        class="BaseLabelText BaseTextarea__label"
                                                                        style="display: none;">
                                                                        <span data-v-e2593c18=""
                                                                            class="BaseLabelText__text"></span><!---->
                                                                    </div><textarea data-v-be77401d=""
                                                                        placeholder="주문 요청사항을 500자 내로 입력해주세요."
                                                                        maxlength="500"
                                                                        class="BaseTextarea__textarea"></textarea>
                                                                    <div data-v-be77401d=""
                                                                        class="BaseTextarea__assistiveArea">
                                                                        <div data-v-86c06fc2="" data-v-be77401d=""
                                                                            class="BaseTextHelper BaseTextHelper--default">
                                                                            <!---->
                                                                            <div data-v-86c06fc2=""
                                                                                class="inline-flex items-center">입력 후
                                                                                저장버튼을 눌러주세요</div>
                                                                        </div>
                                                                        <div data-v-612abd8a="" data-v-be77401d=""
                                                                            class="BaseTextCounter BaseTextCounter--default">
                                                                            <span data-v-612abd8a="">0/500</span>
                                                                        </div>
                                                                    </div>
                                                                </div><button data-v-524f63ea="" data-v-7940d6dd=""
                                                                    type="outline"
                                                                    class="CoreButton CoreButton--block BaseButtonRectangle body1-bold-small BaseButtonRectangle__outline ml-[8px]"
                                                                    style="background-color: rgb(255, 255, 255); color: rgb(239, 112, 20); height: 88px; width: 92px; flex-direction: row; --core-button-padding-x: 16; --button-rectangle-border-color: #ef7014;"><!----><!---->
                                                                    <div data-v-524f63ea=""
                                                                        class="inline-flex items-center"><span
                                                                            data-v-524f63ea=""
                                                                            class="CoreButton__text">저장</span></div>
                                                                </button>
                                                            </div>
                                                        </div>
                                                        <div data-v-8cd67775="" class="w-full">
                                                            <div></div><!----><!---->
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>


                                        </div>

                                        <!-- 하단 공방 별 가격 -->
                                        <div data-v-db78b45c="">
                                            <hr data-v-6ef4cf18="" class="BaseDivider" style="--border-color: #f5f5f5;">
                                            <div
                                                class="grid grid-flow-col gap-x-[1px] body3-regular-small py-[16px] grid-cols-2">
                                                <div
                                                    class="flex items-center flex-col h-full border-r-[1px] border-[#f5f5f5]">
                                                    <div class="gray-666--text mb-[8px]">작품 금액</div>
                                                    <div class="body1-bold-small">{{ atelierTotalPrice(atelier) }}원
                                                    </div>
                                                    <div class="flex mt-[2px]">
                                                        <div data-v-a1957620=""
                                                            class="BaseDecorateText transform-gpu whitespace-pre inline mr-[4px] last:mr-0">
                                                            <span data-v-a1957620=""
                                                                class="DecorateText DecorateText--bold"
                                                                style="font-size: 10px; color: rgb(255, 75, 80); background-color: inherit;">즉시할인가</span>
                                                        </div>
                                                    </div>
                                                </div><!----><!----><!----><!---->
                                                <div class="flex items-center flex-col h-full">
                                                    <div class="gray-666--text mb-[8px]">주문 금액</div>
                                                    <div class="body1-bold-small">{{ atelierTotalPrice(atelier) }}원
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- 작가 더보기 -->
                                        <div data-v-db78b45c="">
                                            <hr data-v-6ef4cf18="" class="BaseDivider" style="--border-color: #f5f5f5;">
                                            <div
                                                class="w-full h-[46px] flex items-center justify-center cursor-pointer">
                                                <div data-v-a1957620=""
                                                    class="BaseDecorateText transform-gpu whitespace-pre inline inline-flex">
                                                    <span data-v-a1957620="" class="DecorateText DecorateText--bold"
                                                        style="font-size: 12px; color: rgb(80, 95, 205); background-color: inherit;">작가님
                                                        작품 더보기</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div data-v-db78b45c="" class="CartArtist__footer">
                                        <div data-v-db78b45c="" class="CartArtist__footerInner">
                                            <div data-v-db78b45c="" class="CartArtist__footerInnerBorder"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- 오른쪽 가격 사이드바  -->
                            <div data-v-a5290452="" class="w-[400px] ml-[30px] relative">
                                <div data-v-adaf8eae="" data-v-a5290452="" class="CartPriceInfo">
                                    <div data-v-adaf8eae=""
                                        class="border border-[#e1e1e1] rounded-[12px] pt-[10px] pb-[20px] px-[24px] white--background">
                                        <div data-v-adaf8eae="" class="subtitle2-bold-small my-[14px]">주문 예상 금액</div>
                                        <hr data-v-6ef4cf18="" data-v-adaf8eae="" class="BaseDivider"
                                            style="--border-color: #333333;">
                                        <div data-v-936440ee="" data-v-adaf8eae="" class="PriceInfo">
                                            <div data-v-936440ee="" class="py-[20px]">
                                                <div data-v-936440ee="" class="PriceInfo__item mb-[12px]">
                                                    <div data-v-936440ee="">총 작품금액</div>
                                                    <div data-v-936440ee="" class="subtitle3_bold_small">{{
                                                        totalCartInfo.totalPrice || 0
                                                    }}원</div>
                                                </div>
                                                <!----><!----><!----><!---->

                                                <div data-v-936440ee=""
                                                    class="PriceInfo__item mb-[16px] last:mb-0 !items-start">
                                                    <div data-v-936440ee="">배송비</div>
                                                    <div data-v-936440ee=""
                                                        class="flex flex-col items-end justify-center">
                                                        <div data-v-936440ee="" class="flex items-center justify-end">
                                                            <div data-v-a1957620="" data-v-936440ee=""
                                                                class="BaseDecorateText transform-gpu whitespace-pre inline mr-[4px] last:mr-0">
                                                                <span data-v-a1957620="" class="DecorateText"
                                                                    style="font-size: 12px; color: rgb(51, 51, 51); background-color: inherit;">CGB는
                                                                    전 작품</span>
                                                            </div>
                                                            <div data-v-a1957620="" data-v-936440ee=""
                                                                class="BaseDecorateText transform-gpu whitespace-pre inline mr-[4px] last:mr-0">
                                                                <span data-v-a1957620=""
                                                                    class="DecorateText__badge"><!---->
                                                                    <div data-v-c3bdd300="" data-v-a1957620=""
                                                                        class="BaseBadgeFreeShipping"
                                                                        style="--icon-width: 48; --icon-height: 18;">
                                                                        <div data-v-c3bdd300=""
                                                                            class="BaseBadgeFreeShipping__icon"></div>
                                                                    </div>
                                                                </span>
                                                            </div>
                                                        </div><!---->
                                                    </div>
                                                </div>


                                                <div data-v-62ba81fa="" data-v-936440ee=""
                                                    class="BaseBannerMembership cursor-pointer mb-[16px] last:mb-0">
                                                    <div data-v-27c9b08d="" data-v-62ba81fa=""
                                                        class="BaseIconMembershipColor"
                                                        style="--icon-width: 24; --icon-height: 24;">
                                                        <div data-v-27c9b08d="" class="BaseIconMembershipColor__icon">
                                                        </div>
                                                    </div>
                                                    <div data-v-a1957620="" data-v-62ba81fa=""
                                                        class="BaseDecorateText transform-gpu whitespace-pre inline flex ml-[4px]">
                                                        <span data-v-a1957620="" class="DecorateText"
                                                            style="font-size: 13px; color: rgb(255, 255, 255); background-color: inherit;">멤버십
                                                            가입시 </span>
                                                    </div>
                                                    <div data-v-a1957620="" data-v-62ba81fa=""
                                                        class="BaseDecorateText transform-gpu whitespace-pre inline flex ml-[4px]">
                                                        <span data-v-a1957620="" class="DecorateText DecorateText--bold"
                                                            style="font-size: 13px; color: rgb(255, 255, 255); background-color: inherit;">4천원
                                                            쿠폰 + 5% 추가할인</span>
                                                    </div><svg data-v-6d2bd019="" data-v-62ba81fa="" width="24"
                                                        height="24" viewBox="0 0 24 24"
                                                        xmlns="http://www.w3.org/2000/svg" class="BaseIcon"
                                                        style="width: 20px; height: 20px; opacity: 1; fill: currentcolor; --BaseIcon-color: #ffffff;">
                                                        <g clip-path="url(#clip0_124_2947)">
                                                            <path fill-rule="evenodd" clip-rule="evenodd"
                                                                d="M9.53039 5.46973L15.5304 11.4697C15.7967 11.736 15.8209 12.1527 15.603 12.4463L15.5304 12.5304L9.53039 18.5304L8.46973 17.4697L13.9391 12.0001L8.46973 6.53039L9.53039 5.46973Z">
                                                            </path>
                                                        </g>
                                                        <defs>
                                                            <clipPath id="clip0_124_2947">
                                                                <rect width="24" height="24"></rect>
                                                            </clipPath>
                                                        </defs>
                                                    </svg>
                                                </div>
                                            </div>
                                            <hr data-v-6ef4cf18="" data-v-936440ee="" class="BaseDivider"
                                                style="--border-color: #f5f5f5;">
                                            <div data-v-936440ee="" class="PriceInfo__item py-[16px]">
                                                <div data-v-936440ee="" class="subtitle3-bold-small">총
                                                    {{ totalCartInfo.value.totalCount || 0 }}건 주문금액</div>
                                                <div data-v-936440ee="" class="flex flex-col items-end justify-center">
                                                    <div data-v-936440ee="" class="subtitle1-bold-small">{{
                                                        totalCartInfo.value.totalPrice || 0
                                                    }}원
                                                    </div>
                                                    <!---->
                                                </div>
                                            </div>
                                        </div><!---->
                                        <div data-v-adaf8eae="" class="flex justify-between w-full"><button
                                                data-v-524f63ea="" data-v-7940d6dd="" type="outline"
                                                class="CoreButton BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__outline w-[112px] mr-[8px]"
                                                style="background-color: rgb(255, 255, 255); color: rgb(51, 51, 51); height: 44px; flex-direction: row; --core-button-padding-x: 16; --button-rectangle-border-color: #acacac;"><!----><!---->
                                                <div data-v-524f63ea="" class="inline-flex items-center"><span
                                                        data-v-524f63ea="" class="CoreButton__text">선물하기</span></div>
                                            </button><button @click="submitOrder" data-v-524f63ea="" data-v-7940d6dd=""
                                                type="fill"
                                                class="CoreButton BaseButtonRectangle subtitle3-bold-small BaseButtonRectangle__fill grow"
                                                style="background-color: rgb(239, 112, 20); color: rgb(255, 255, 255); height: 44px; flex-direction: row; --core-button-padding-x: 16;"><!----><!---->
                                                <div data-v-524f63ea="" class="inline-flex items-center"><span
                                                        data-v-524f63ea="" class="CoreButton__text">3건 주문하기</span></div>
                                            </button></div>
                                    </div>
                                </div>
                            </div>
                        </div><!----><!----><!----><!----><!----><!----><!----><!----><!---->
                    </div>
                </div><!--]-->
                <div class="TheFabContainer" data-v-4e58ad83="" data-v-0397dfb3=""><!--[--><!----><!----><!--]--></div>
            </div><!----><!---->
            <div class="BaseSnackbar__fadeOut !hidden BaseSnackbar TheSnackbar" data-v-4e58ad83="" data-v-ac6313c6="">
                <div class="BaseSnackbar__wrapper boxShadow__x-large py-[8px] pl-[12px] pr-[12px]" data-v-ac6313c6="">
                    <!---->
                    <div class="body1-regular-medium line-clamp-2 whitespace-pre-line" data-v-ac6313c6=""></div><!---->
                </div>
            </div><!----><!---->
        </div>
    </div>
</template>

<script>
import { onMounted, ref, computed } from 'vue';
import { useCartStore } from '@/stores/useCartStore';
export default {

    setup() {
        const cartStore = useCartStore();
        const ateliers = ref([]);
        const allCart = ref(false);

        const fetchCartList = async () => {
            await cartStore.fetchCartList();
            // 서버에서 가져온 cartList를 통해 ateliers 상태를 초기화
            ateliers.value = cartStore.cartList.map(atelier => ({
                ...atelier,
                productList: atelier.productList.map(product => ({
                    ...product,
                    checked: product.checked // 각 상품의 체크 상태 유지
                })),
            }));
        };

        // const fetchCartList = () => {
        //     cartStore.fetchCartList();

        // }
        //전체 선택
        const toggleAll = () => {
            allCart.value = !allCart.value;
            ateliers.value = ateliers.value.map((atelier) => ({
                ...atelier,
                checked: allCart.value,
                productList: atelier.productList.map((product) => ({
                    ...product,
                    checked: allCart.value,
                })),
            }));
        };
        const selectedItems = computed(() => {
            return ateliers.value.flatMap(atelier =>
                atelier.productList
                    .filter(product => product.checked)
                    .map(product => ({
                        atelierIdx: atelier.atelierIdx,
                        productIdx: product.productIdx,
                        productName: product.productName
                    }))
            );
        });


        // 공방 체크박스 toggle 함수
        const toggleAtelier = (atelier) => {
            atelier.checked = !atelier.checked;
            atelier.productList.forEach((product) => {
                product.checked = atelier.checked;
            });
        };

        // 상품 체크박스 toggle 함수
        const toggleProduct = (atelier, product) => {
            product.checked = !product.checked;
            atelier.checked = atelier.productList.every((prod) => prod.checked);

        };

        // 선택된 상품의 공방별 가격 계산
        const atelierTotalPrice = (atelier) => {
            const total = atelier.productList.reduce((sum, product) => {
                if (product.checked) {
                    const productTotal = product.optionList.reduce((optionSum, option) => {
                        console.log('Option Price:', option.price, 'Option Count:', option.count);
                        return optionSum + (option.price * option.count);
                    }, 0);
                    return sum + productTotal;
                }
                return sum;
            }, 0);
            return total;
        };

        // 전체 가격 계산
        const totalCartInfo = computed(() => {
            console.log("aa");
            return ateliers.value.reduce((result, atelier) => {
                atelier.productList.forEach(product => {
                    if (product.checked) {
                        result.totalPrice += product.optionList.reduce((sum, option) => {
                            console.log('Option Price:', option.price, 'Option Count:', option.count);
                            return sum + (option.price * option.count);
                        }, 0);
                        result.totalCount += 1;
                    }
                });
                return result;
            }, { totalPrice: 0, totalCount: 0 }); // 초기 값으로 0 설정
        });

        const submitOrder = () => {
            const selectedItems = ateliers.value
                .flatMap((atelier) =>
                    atelier.productList
                        .filter((product) => product.checked)
                        .map((product) => ({
                            cartIdx: product.cartIdx,
                            deliveryInstructions: product.deliveryInstructions, // 전달사항 추가
                        }))
                );
            console.log('선택된 상품:', selectedItems);

            // 선택한 상품 정보를 API를 통해 서버로 전송
            cartStore.submitOrder(selectedItems);
        };

        //수량 감소
        const decreaseQuantity = async (option) => {
            if (option.count > 1) {
                option.count--;
                await updateQuantity(option);
            }
        };

        // 수량 증가
        const increaseQuantity = async (option) => {
            option.count++;
            await updateQuantity(option);
        };

        // 수량 변경
        const updateQuantity = async (option) => {
            try {
                await cartStore.updateQuantity(option.cartIdx, option.count);
                await fetchCartList();  // Refresh the cart list to reflect the new quantity
            } catch (error) {
                console.error('Error updating quantity:', error);
            }
        };

        onMounted(() => {
            fetchCartList();
        });

        return {
            fetchCartList,
            submitOrder,
            toggleProduct,
            toggleAtelier,
            toggleAll,
            atelierTotalPrice,
            decreaseQuantity,
            increaseQuantity,
            updateQuantity,
            selectedItems,
            allCart,
            totalCartInfo,
            cartStore
        }
    }
}
</script>
