package jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    public void cadastra(Produto produto) throws SQLException{
        Connection conn = FabricaDeConexao.getConexao();
        String sql = "insert into produtos (nome, preco, validade, categoria) values (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, produto.getNome());
        ps.setBigDecimal(2, produto.getPreco());
        ps.setDate(3, Date.valueOf(produto.getValidade()));
        ps.setString(4, String.valueOf(produto.getCategoria()));

        ps.execute();
        ps.close();
        conn.close();
    }

    public List<Produto> lista() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        Connection conn = FabricaDeConexao.getConexao();
        String sql = "select * from produtos";
        PreparedStatement st = conn.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        while (rs.next()){
            Produto produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getBigDecimal("preco"));
            produto.setValidade(rs.getDate("validade").toLocalDate());
            produto.setCategoria(Categoria.valueOf(rs.getString("categoria")));

            produtos.add(produto);
        }

        rs.close();
        st.close();
        conn.close();
        return produtos;
    }

    public Produto buscaPor(int id) throws SQLException {
        Connection conn = FabricaDeConexao.getConexao();
        String sql = "select * from produtos where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        Produto produto = new Produto();
        if(rs.next()){
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getBigDecimal("preco"));
            produto.setValidade(rs.getDate("validade").toLocalDate());
            produto.setCategoria(Categoria.valueOf(rs.getString("categoria")));
        }

        rs.close();
        ps.close();
        conn.close();
        return produto;
    }

    public void remove(Integer id) throws SQLException {
        Connection conn = FabricaDeConexao.getConexao();
        String sql = "delete from produtos where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();
        conn.close();
    }

    public void atualiza(Produto produto) throws SQLException {
        Connection conn = FabricaDeConexao.getConexao();
        String sql = "update produtos set nome = ?, preco = ?, validade = ?, categoria = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, produto.getNome());
        ps.setBigDecimal(2, produto.getPreco());
        ps.setDate(3, Date.valueOf(produto.getValidade()));
        ps.setString(4, String.valueOf(produto.getCategoria()));
        ps.setInt(5, produto.getId());

        ps.execute();
        ps.close();
        conn.close();

    }
}
