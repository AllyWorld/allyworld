package com.app.allyworld.website.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.app.allyworld.website.entity.Comments;
import com.app.allyworld.website.entity.Likes;
import com.app.allyworld.website.entity.Post;

@Controller
public class WebsiteController {

	@Autowired
	private RestTemplate restTemplate;
	private Post post;
	/*
	 * @RequestMapping("/user") public Principal user(Principal principal) { return
	 * principal; }
	 */

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/addNewPost")
	public String addNewPost(Map map) {
		map.put("post", new Post());
		return "AddPostForm";
	}

	@RequestMapping("/getAllPosts")
	public ModelAndView getAllposts(Model model) {
		List<Post> posts = restTemplate.getForObject("http://localhost:8989/posts", List.class);
		//model.addAttribute("p",posts);
		return new ModelAndView("PostDetails", "posts", posts);
	}

	@RequestMapping("/createNewPost")
	public String createNewAccount(/* @RequestParam("postId") Integer postId*/@RequestParam("profileId") Integer profileId,
			@RequestParam("status") String status, @RequestParam("url") String url,
			@RequestParam("likes") Integer likes, @RequestParam("likesProfileId")  List<Integer> likesProfileId,
			@RequestParam("commentProfileId") List<Integer> commentProfileId, @RequestParam("comment") String comment,
			@RequestParam("likesComment") Integer likesComment, Model model) {
		Post post = new Post(profileId,status,url, new Likes(likes,likesProfileId),new Comments(commentProfileId, comment, likesComment));
		ResponseEntity<Post> entityOne = restTemplate.postForEntity("http://localhost:8989/posts", post,Post.class);
		ResponseEntity<List> entity = restTemplate.getForEntity("http://localhost:8989/posts", List.class);
		model.addAttribute("posts", entity.getBody());
		return "PostDetails";
	}

	@RequestMapping("/getPostByPostId")
	public String getPostByPostId() {
		return "SearchByPost";
	}

	@RequestMapping("/searchByPostId")
	public String getPostById(@RequestParam("postId") Integer postId, Model model) {
		Post post = new Post();
		post.setPostId(postId);
		ResponseEntity<Post> post1 = restTemplate.getForEntity("http://localhost:8989/posts/?postId=" + postId,
				Post.class);
		model.addAttribute("post", post1.getBody());
		return "PostDetails";
	}

	@RequestMapping("/getPostByProfileId")
	public String getPostByProfileId() {
		return "SearchByProfile";
	}

	@RequestMapping("/searchByProfileId")
	public ModelAndView getPostByProfile(@RequestParam("profileId") Integer profileId) {
		List posts = restTemplate.getForObject("http://localhost:8989/posts/{profileId}", List.class, profileId);
		return new ModelAndView("PostDetails", "posts", posts);
	}
	
	@RequestMapping("/updatePost")
	public String update() {
		return "UpdateForm";
	}
	
	@RequestMapping("/searchByPostIdForUpdate")
	public String updateByPost(@RequestParam("postId") Integer postId, Model model) {
		 post = new Post();
		post.setPostId(postId);
		ResponseEntity<Post> post1 = restTemplate.getForEntity("http://localhost:8989/posts/?postId=" + postId,
				Post.class);
		model.addAttribute("post", post1.getBody());
		return "UpdateDetails";
	}
	
	@RequestMapping("/updatePostForUpdate")
	public String updatePost(/* @ModelAttribute Post post, */@RequestParam("postId") Integer postId,@RequestParam("profileId") Integer profileId,@RequestParam("status") String status, @RequestParam("url") String url,
			@RequestParam("likes") Integer likes, @RequestParam("likesProfileId")  List<Integer> likesProfileId,
			@RequestParam("commentProfileId") List<Integer> commentProfileId, @RequestParam("comment") String comment,
			@RequestParam("likes1") Integer likesComment, Model model ) {
		post.setPostId(postId);
		post.setProfileId(profileId);
		post.setStatus(status);
		post.setUrl(url);
		post.setLikes(new Likes(likes,likesProfileId));
		post.setComments(new Comments(commentProfileId,comment,likesComment));
		System.out.println(post);
		restTemplate.put("http://localhost:8989/posts/",post);
		ResponseEntity<Post> post1 = restTemplate.getForEntity("http://localhost:8989/posts/?postId=" + postId,
				Post.class);
		model.addAttribute("post", post1.getBody());
		return "PostDetails";
		/* System.out.println(post); */
		//model.addAttribute("post", post);
	}
	
	@RequestMapping("/deletePost")
	public String delete() {
		return "DeleteForm";
	}
	
	@RequestMapping("/deleteByPostId")
	public String deletePost(@RequestParam("postId") Integer postId) {
		 restTemplate.delete("http://localhost:8989/posts/{postId}", postId);
		return "DisplayDelete";
	}
}
