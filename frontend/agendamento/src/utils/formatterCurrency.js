export const maskCurrency = (val) => {
  let onlyNumbers = String(val).replace(/\D/g, "");
  if (!onlyNumbers) return "R$ 0,00";

  let value = (Number(onlyNumbers) / 100).toFixed(2);

  return new Intl.NumberFormat("pt-BR", {
    style: "currency",
    currency: "BRL",
  }).format(value);
};

export const demaskCurrency = (value) => {
    if (!value) return 0;
    let clearValue = value.replace(/\D/g, "");
    return Number(clearValue) / 100;
}