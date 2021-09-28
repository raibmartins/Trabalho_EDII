package com.matheusrai;

import java.util.Arrays;
import java.util.List;

public enum RegisterType {

    HEADER(
            0,
            "tabela",
            Field.build().key("curso").start(1).end(11).classe(String.class),
            Field.build().key("dataProcessamento").start(11).end(19).classe(String.class),
            Field.build().key("periodoInicial").start(19).end(26).classe(String.class),
            Field.build().key("periodoFinal").start(26).end(33).classe(String.class),
            Field.build().key("sequencia").start(33).end(40).classe(Integer.class),
            Field.build().key("version").start(40).end(43).classe(String.class)
    ),
    OPERACAO(
            1,
            "tabela",
            Field.build().key("fase").start(1).end(8).classe(String.class),
            Field.build().key("quantidadeDisciplinas").start(8).end(10).classe(Integer.class),
            Field.build().key("quantidadeProfessores").start(10).end(12).classe(Integer.class)
    ),
    DISCIPLINAS(
            2,
            "tabela",
            Field.build().key("codigo").start(1).end(7).classe(String.class),
            Field.build().key("diaDaSemana").start(7).end(9).classe(Integer.class),
            Field.build().key("quantidadeProfessores").start(9).end(11).classe(Integer.class)
    ),
    PROFESSORES(
            3,
            "tabela",
            Field.build().key("nome").start(1).end(41).classe(String.class),
            Field.build().key("tituloDocente").start(41).end(43).classe(String.class)
    ),
    TRAILER(
            9,
            "tabela",
            Field.build().key("totalDeRegistros").start(1).end(12).classe(Integer.class)

    );

    private final int code;
    private final List<Field> fields;
    private final String table;

    RegisterType(int code, String table, Field... fields) {
        this.code = code;
        this.fields = Arrays.asList(fields);
        this.table = table;
    }

    public int getCode() {
        return code;
    }

    public List<Field> getCampos() {
        return fields;
    }

    public String getTable() {
        return table;
    }

    public static RegisterType toEnum(String registro) {
        int codigo = Integer.parseInt(registro.substring(0,1));
        for (RegisterType value : RegisterType.values()) {
            if(value.getCode() == codigo) {
                return value;
            }
        }
        return null;
    }

}
