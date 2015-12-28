package br.com.fiap.pizza;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProdutosDAO extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "PRODUTOS";

	public ProdutosDAO(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	public void cargaInicial() {
		
		SQLiteDatabase db = this.getWritableDatabase();
		String drop = "DROP TABLE IF EXISTS PRODUTOS";
		db.execSQL(drop);
		String criaBase = "CREATE TABLE PRODUTOS (id, tipo, nome, conteudo, valor)";
		db.execSQL(criaBase);

		addProduto(db, 0, "pizza", "Peperone", "Queijo, Peperone", 30D);
		addProduto(db, 1, "pizza", "Mussarela", "Queijo, Molho", 25D);
		addProduto(db, 2, "pizza", "Frango", "Frango, Queijo", 35D);
		addProduto(db, 3, "pizza", "Portuguesa", "Queijo, Tomate, Calabresa", 40D);
		addProduto(db, 4, "pizza", "Quatro queijos", "mozzarella, gorg., parmesão e Catupiry", 45D);
		
		addProduto(db, 5, "bebidas", "Coca", "", 5D);
		addProduto(db, 6, "bebidas", "Fanta", "", 5D);
		addProduto(db, 7, "bebidas", "Guarana", "", 5D);
		
		
	}

	public void addProduto(SQLiteDatabase db, Integer id, String tipo, String nome,
			String conteudo, Double preco) {
		ContentValues values = new ContentValues();
		values.put("id", id);
		values.put("tipo", tipo);
		values.put("nome", nome);
		values.put("conteudo", conteudo);
		values.put("valor", preco);
		db.insert("PRODUTOS", null, values);
	}
	

	public List<Item> getProdutos(String tipo) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query("PRODUTOS", new String[] { "id", "tipo",
				"nome", "conteudo", "valor" }, " tipo = ?",
				new String[] { tipo }, null, null, null, null);

		List<Item> pizzaList = null;

		if (cursor != null) {
			pizzaList = new ArrayList<Item>();
			while (cursor.moveToNext()) {
				Item p = new Item();
				p.setId(cursor.getInt(0));
				p.setTipo(cursor.getString(1));
				p.setNome(cursor.getString(2));
				p.setConteudo(cursor.getString(3));
				p.setValor(cursor.getDouble(4));
				pizzaList.add(p);
			}
		}
		return pizzaList;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}