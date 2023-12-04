import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.condex.pmdmpractica1.databinding.RecyclerViewPesosBinding
import com.condex.pmdmpractica1.ui.adapters.Adapter
import com.condex.pmdmpractica1.data.DataSource

class MainFragment2 : Fragment() {
    private var _binding: RecyclerViewPesosBinding? = null
    private val binding get() = _binding!!
    private lateinit var imcadapter: Adapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = RecyclerViewPesosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        imcadapter = Adapter(requireContext(), DataSource.dataSourceIMC.getImc(requireContext()))
        binding.imclist1.adapter = imcadapter
        binding.imclist1.setHasFixedSize(true)
        binding.imclist1.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onResume() {
        super.onResume()
        updateData()
    }

    private fun updateData() {
        // Aquí actualizas los datos de tu adapter
        imcadapter.setData(DataSource.dataSourceIMC.getImc(requireContext()))
        imcadapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}