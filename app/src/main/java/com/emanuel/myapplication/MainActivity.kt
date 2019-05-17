package com.emanuel.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.emanuel.myapplication.adapters.RepoAdapter
import com.emanuel.myapplication.database.entities.GIthubRepo
import com.emanuel.myapplication.database.viewmodels.GithubRepoVIewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: RepoAdapter
    lateinit var viewModel: GithubRepoVIewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    fun bind(){
        adapter=RepoAdapter(ArrayList())
        viewModel=ViewModelProviders.of(this).get(GithubRepoVIewModel::class.java)
        rv_repo.apply{
            adapter=this@MainActivity.adapter
            layoutManager=LinearLayoutManager(this@MainActivity)
        }
        viewModel.getAll().observe(this, Observer{
            adapter.updateList(it)
        })
        btn_add.setOnClickListener{
            viewModel.insert(GIthubRepo(et_repo.text.toString()))
        }
    }
}
