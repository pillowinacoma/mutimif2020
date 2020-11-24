package fr.univlyon1.m1if.m1if10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.univlyon1.m1if.m1if10.model.Hashtag;
import fr.univlyon1.m1if.m1if10.model.InstaParser;
import fr.univlyon1.m1if.m1if10.model.Post;

class InstaParserTest {
	
	private InstaParser iP;
	private List<Post> lP;
	
	@Test
	void test() {
		//When
		lP = iP.parser("{\"graphql\":{\"hashtag\":{\"edge_hashtag_to_top_posts\":{\"edges\":[{\"node\":{\"__typename\":\"GraphImage\",\"id\":\"2445925268122952969\",\"edge_media_to_caption\":{\"edges\":[{\"node\":{\"text\":\"Kavuşmaya Son 1🤞🏻🖤\\n•\\n•\\n•\\n#rambel #ramo #muratyıldırım #esrabilgiç #menajerimiara #kuzeyyıldızıilkaşk #masumlarapartmanı #arıza #tiktok #sençalkapımı #kırmızıoda #çukur #yenihayat #turkdizi #gönüldağı #kesfetteyim #sefirinkizidizi #edho #mucizedoktor #doğduğunevkaderindir #barajdizi #hercai #yasakelma #kuruluşosman #öğretmen #alevalev #birzamanlarçukurova #hekimoğlu #zümrüdüanka #muzik\"}}]},\"shortcode\":\"CHxrBKBnuUJ\",\"edge_media_to_comment\":{\"count\":0},\"taken_at_timestamp\":1605797035,\"dimensions\":{\"height\":1080,\"width\":1080},\"display_url\":\"https://scontent-mrs2-1.cdninstagram.com/v/t51.2885-15/e35/126057824_847758182718341_7203218836908680033_n.jpg?_nc_ht=scontent-mrs2-1.cdninstagram.com&_nc_cat=105&_nc_ohc=srtDppW7ee8AX_GhPgF&tp=18&oh=ce2ad9834b76c92b3d2dfcfe6929c83f&oe=5FDF75C5\",\"edge_liked_by\":{\"count\":158},\"edge_media_preview_like\":{\"count\":-1},\"owner\":{\"id\":\"39989535267\"},\"thumbnail_src\":\"https://scontent-mrs2-1.cdninstagram.com/v/t51.2885-15/sh0.08/e35/s640x640/126057824_847758182718341_7203218836908680033_n.jpg?_nc_ht=scontent-mrs2-1.cdninstagram.com&_nc_cat=105&_nc_ohc=srtDppW7ee8AX_GhPgF&tp=24&oh=6a0fd9dabac15c9a8af6d8443a43b62e&oe=5FDE767F\",\"thumbnail_resources\":[{\"src\":\"https://scontent-mrs2-1.cdninstagram.com/v/t51.2885-15/e35/s150x150/126057824_847758182718341_7203218836908680033_n.jpg?_nc_ht=scontent-mrs2-1.cdninstagram.com&_nc_cat=105&_nc_ohc=srtDppW7ee8AX_GhPgF&tp=15&oh=174a6cce583fc25fb17b13fa8794a5a6&oe=5FDF73FC\",\"config_width\":150,\"config_height\":150},{\"src\":\"https://scontent-mrs2-1.cdninstagram.com/v/t51.2885-15/e35/s240x240/126057824_847758182718341_7203218836908680033_n.jpg?_nc_ht=scontent-mrs2-1.cdninstagram.com&_nc_cat=105&_nc_ohc=srtDppW7ee8AX_GhPgF&tp=15&oh=ecbd41382f2cf61fe62c5f0168a0ad99&oe=5FDEE17E\",\"config_width\":240,\"config_height\":240},{\"src\":\"https://scontent-mrs2-1.cdninstagram.com/v/t51.2885-15/e35/s320x320/126057824_847758182718341_7203218836908680033_n.jpg?_nc_ht=scontent-mrs2-1.cdninstagram.com&_nc_cat=105&_nc_ohc=srtDppW7ee8AX_GhPgF&tp=15&oh=4a8362ac43fda7198c0f17949c17f43d&oe=5FDF0484\",\"config_width\":320,\"config_height\":320},{\"src\":\"https://scontent-mrs2-1.cdninstagram.com/v/t51.2885-15/e35/s480x480/126057824_847758182718341_7203218836908680033_n.jpg?_nc_ht=scontent-mrs2-1.cdninstagram.com&_nc_cat=105&_nc_ohc=srtDppW7ee8AX_GhPgF&tp=15&oh=4a3c038da4f6ff9ba9cebc3b01090ad2&oe=5FE0A6C5\",\"config_width\":480,\"config_height\":480},{\"src\":\"https://scontent-mrs2-1.cdninstagram.com/v/t51.2885-15/sh0.08/e35/s640x640/126057824_847758182718341_7203218836908680033_n.jpg?_nc_ht=scontent-mrs2-1.cdninstagram.com&_nc_cat=105&_nc_ohc=srtDppW7ee8AX_GhPgF&tp=24&oh=6a0fd9dabac15c9a8af6d8443a43b62e&oe=5FDE767F\",\"config_width\":640,\"config_height\":640}],\"is_video\":false,\"accessibility_caption\":\"Photo shared by 𝐑𝐚𝐦𝐁𝐞𝐥🖤 on November 19, 2020 tagging @mrtyldrm, @esbilgic, and @kesfetplatform01. L’image contient peut-être : 2 personnes.\"}}]}}}}");
		
		//Then
		Post p = lP.iterator().next();
		
		assertEquals("2445925268122952969",p.getId());
		assertEquals("https://scontent-mrs2-1.cdninstagram.com/v/t51.2885-15/e35/126057824_847758182718341_7203218836908680033_n.jpg?_nc_ht=scontent-mrs2-1.cdninstagram.com&_nc_cat=105&_nc_ohc=srtDppW7ee8AX_GhPgF&tp=18&oh=ce2ad9834b76c92b3d2dfcfe6929c83f&oe=5FDF75C5",p.getUrl());
		assertEquals("39989535267",p.getName());
		assertEquals("Photo shared by 𝐑𝐚𝐦𝐁𝐞𝐥🖤 on November 19, 2020 tagging @mrtyldrm, @esbilgic, and @kesfetplatform01. L’image contient peut-être : 2 personnes.",p.getDescription());
		assertEquals(158,p.getNbLike());
		
	}

}
