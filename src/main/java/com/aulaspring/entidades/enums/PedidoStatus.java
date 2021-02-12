package com.aulaspring.entidades.enums;

public enum PedidoStatus {

	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);

	private int codigo;
	
	private PedidoStatus(int codigo) {
		
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static PedidoStatus valor(int c) {

		for(PedidoStatus ps : PedidoStatus.values()) {
			
			if(ps.getCodigo() == c) {
				
				return ps;
			}
		}
		
		throw new IllegalArgumentException("Esse código de status do pedido é invalido");
	}
}
