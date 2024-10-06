const formatPrice = (number) => {
  return number.toLocaleString("ko-KR", { style: "currency", currency: "KRW" });
};

export { formatPrice };
